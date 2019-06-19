package org.bs.web.controller.hyd;

import org.bs.web.common.CommonConf;
import org.bs.web.mapper.hyd.MovieMapper;
import org.bs.web.pojo.movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("hyd")
public class MovieController {
    @Autowired
    private MovieMapper movieMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增排期数据 包含电影ID 放映厅ID
     * @param paiqiBean
     * @return
     */
    @RequestMapping(value = "/movie/saveMovie")
    public Integer saveMovie(@RequestBody PaiqiBean paiqiBean) throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        SimpleDateFormat sim = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        // 取出输入的排期时间
        String startTime = paiqiBean.getStartTime();

        String[] s = startTime.split(" ");
        Date ymd = sdf.parse(s[0]);
        Date hms = sim.parse(s[1]);

        // 查询营业时间段  用于判断输入的是否在营业时间段内
        BusinessTimeBean businessTime = movieMapper.findBusinessTime();
        Date beginParse = sim.parse(businessTime.getBeginTime());
        Date endParse = sim.parse(businessTime.getEndTime());

        //判断排期时间是否符合该影院营业时间，若不符合 则返回1   与营业时间不符
        if ( hms.compareTo(beginParse) < 0 || hms.compareTo(endParse) > 0 ){
            return 1;
        }

       // 获取电影ID
        Integer movieId = paiqiBean.getMovieId();

        // 据对应的ID查询出档期时间段
        MovieTimeBean movieTime = movieMapper.findMovieTime(movieId);
        String strStartDate = movieTime.getStartDate();
        String strEndDate = movieTime.getEndDate();

        Date startDate = sdf.parse(strStartDate);
        Date endDate = sdf.parse(strEndDate);

        //判断排期日期 是否符合该电影档期，若不符合则返回2  与档期不符
        if (ymd.compareTo(startDate) <0 || ymd.compareTo(endDate) > 0)
            return 2;

        // 获取放映厅ID
        Integer hallId = paiqiBean.getHallId();
        //System.out.println(hallId);
        // 根据放映厅ID查询对应的排期信息
        List<PaiqiBean> hallOnPaiqi = movieMapper.findHallOnPaiqi(hallId,s[0]);

        List<StartAndEndBean> startAndEndBeans = new ArrayList<>();
        for (PaiqiBean paiqi : hallOnPaiqi){
            String strStartTime = paiqi.getStartTime();
            Date start = sim.parse(strStartTime);
            int length = movieMapper.findMovieLengthById(paiqi.getMovieId());
            Date end = addDate(start, length + 10);
            StartAndEndBean startAndEndBean = new StartAndEndBean();
            startAndEndBean.setStart(start);
            startAndEndBean.setEnd(end);
            startAndEndBeans.add(startAndEndBean);
        }

        //获取当前电影片场
        int length = movieMapper.findMovieLengthById(movieId);
        boolean booTime = true;
        for (StartAndEndBean startAndEndBean : startAndEndBeans){
            //获取已有排期信息的  开始播放时间和打扫完毕时间
            //获取开始放映时间
            Date start = startAndEndBean.getStart();
            //获取打扫完毕时间
            Date end = startAndEndBean.getEnd();
            //判断 新增的排期信息的开始放映时间  是否与已有排期的放映时间段冲突
            if (comparaDate(hms,start) >= 0 && comparaDate(hms,end) <=0){
                booTime = false;
                break;
            }

            //获取 新增排期信息的打扫完毕时间
            Date date = addDate(hms, length + 10);

            //判断 新增的排期信息的打扫完毕时间  是否与已有排期的放映时间段冲突
            if (comparaDate(date,start) >= 0 && comparaDate(date,end) <=0){
                booTime = false;
                break;
            }

            if (comparaDate(date,start) <= 0 && comparaDate(date,end) >=0){
                booTime = false;
                break;
            }
        }

        //判断时候有冲突  若有返回 3  排期冲突
        if (!booTime)
            return 3;

        // 最终条件都符合  获取该放映厅可用座位数量
        //生成  指定排期座位总数信息键    生成规则 ： 常量字符串 + 放映厅ID

        Boolean hasKey = redisTemplate.opsForHash().hasKey(CommonConf.SUM_SEATS_KEY, CommonConf.SUM_SEATS_KEY + paiqiBean.getHallId());
        int seats = 0;
        if (hasKey)
            seats = (int) redisTemplate.opsForHash().get(CommonConf.SUM_SEATS_KEY,CommonConf.SUM_SEATS_KEY + paiqiBean.getHallId());
        else{
            seats = movieMapper.findSeatsCountByHallId(paiqiBean.getHallId());
            redisTemplate.opsForHash().put(CommonConf.SUM_SEATS_KEY,CommonConf.SUM_SEATS_KEY + paiqiBean.getHallId(),seats);
        }

        paiqiBean.setSeats(seats);
        int i = movieMapper.saveMovie(paiqiBean);
        //判断是否对数据库有更新操作，若 i <= 0，则说明对数据库无新增操作，顾故返回4 系统故障
        if (i <= 0){
            return 4;
        }

        //若新增数据库成功  将相关数据缓存   返回0   新增成功
        //生成 指定排期信息键   生成规则： CommonConf.PAI_QI_KEY + paiQiId   paiQiId 为  selectKey返回
        redisTemplate.opsForHash().put(CommonConf.PAI_QI_KEY,CommonConf.PAI_QI_KEY + paiqiBean.getId(),paiqiBean);

        //找出 相关 放映厅所有座位信息 并缓存到redis
        //判断redis中是否存在 该 放映厅 相关 座位信息，若不存在 则去数据库中查找
        //生成 主要建   生成规则 ： 常量字符串+放映厅ID
        String primaryKey = CommonConf.HALL_SEATS_KEY + hallId;
        Boolean hasPrimaryKey = redisTemplate.hasKey(primaryKey);

        List<SeatBean> seatBeans = null;
        if (hasPrimaryKey) {
            //List<ProductBean> list = (List) map.values().stream().collect(Collectors.toList());
            seatBeans = (List)redisTemplate.opsForHash().entries(primaryKey).values().stream().collect(Collectors.toList());
        }else {
            seatBeans = movieMapper.findSeatListByHallId(hallId);
            for (SeatBean seatBean : seatBeans){
                //生成 副键 生成规则 ： 常量字符串+座位ID
                String repliKey = CommonConf.SEATS_INFO_KEY + seatBean.getId();
                redisTemplate.opsForHash().put(primaryKey,repliKey,seatBean);
            }
        }

        //将所有排期座位信息 缓存至redis
        for (SeatBean seatBean : seatBeans){
            PaiQiSeatBean paiQiSeatBean = new PaiQiSeatBean();
            paiQiSeatBean.setPaiQiId(paiqiBean.getId());
            paiQiSeatBean.setSeatId(seatBean.getId());

            //生成 key   生成规则   常量字符串+排期ID
            redisTemplate.opsForHash().put(CommonConf.PAI_QI_SEATS_KEY,CommonConf.PAI_QI_SEATS_KEY+paiqiBean.getId(),paiQiSeatBean);
        }

        return 0;
    }

    /**
     * 查询排期    应该根据当前日期 和 电影ID  查询 排期信息
     * @return
     */
    @RequestMapping(value = "/movie/findMoviePaiqi")
    public List<PaiqiBean> findMoviePaiqi(String movieDate,Integer movieId) throws ParseException {
        //获取时间转化对象  时分秒
        SimpleDateFormat sim = new SimpleDateFormat("HH:mm:ss");
        //获取营业标准时间段信息
        List<PaiqiNormalTimeBean> paiqiNormalTimeBeans = movieMapper.findPaiqiNormalTimeBean();
        //根据电影放映时间和电影ID  查询出排期信息
        List<PaiqiBean> moviePaiqis = movieMapper.findMoviePaiqi(movieDate,movieId);
        // 遍历查询到的信息  用来判断天剑是否对应
        for (PaiqiBean paiqiBean : moviePaiqis){
            for (PaiqiNormalTimeBean paiqiNormalTimeBean : paiqiNormalTimeBeans){
                // 获取原有的价格
                double price = paiqiBean.getPrice();
                // 获取播映时间类型段的事件
                Date beginTime = sim.parse(paiqiNormalTimeBean.getBeginTime());
                Date endTime = sim.parse(paiqiNormalTimeBean.getEndTime());

                // 取出放映时间作为判断条件
                String startTime = paiqiBean.getStartTime();
                // 根据空格分割  取出时分秒判断条件
                String[] s = startTime.split(" ");
                // 取出对应的时分秒
                Date hms = sim.parse(s[1]);
                System.out.println(hms);
                boolean b = comparaDate(hms,beginTime) < 0 || comparaDate(hms,endTime) >0;
                // 判断当前时间点处在某一个时间段  如果不在任何时间段 直接continue
                if (comparaDate(hms,beginTime) < 0 || comparaDate(hms,endTime) >0){
                    continue;
                }
                // 利用原有价格 * 价格对应的时间段系数 普通时间段 1  黄金时间段 1.5  夜场时间段  0.7
                price = price * paiqiNormalTimeBean.getCoe();
                // 计算出的价格存到返回体
                paiqiBean.setPrice(price);
            }
            // 取出对应的放映厅ID 用来查询对应放映厅类型的排期信息
            Integer hallId = paiqiBean.getHallId();
            // 获取对应放映厅ID的放映厅类型系数 普通厅为 1  豪华厅为 1.5
            Float coe = movieMapper.findHallTypeCoeByHallId(hallId);
            // 计算对应放映厅类型的价格 并存在返回体中
            paiqiBean.setPrice(paiqiBean.getPrice()*coe);
        }
        // 返回体
        return moviePaiqis;
    }




    //比较时间方法
    private int comparaDate(Date when,Date source){
        return when.compareTo(source);
    }

    //指定分钟数之后的时间
    private Date addDate(Date when,int m){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(when);
        calendar.add(Calendar.MINUTE, m);
        return calendar.getTime();
    }

    @RequestMapping("/page/toDetail")
    public List<PaiqiBean> toDetail(Model model, HttpSession session){
        Integer id = 2;
        List<PaiqiBean> paiqiBean = movieMapper.findPaiQiById(id);
        return paiqiBean;
    }
}
