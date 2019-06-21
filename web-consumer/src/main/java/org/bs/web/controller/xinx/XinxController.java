package org.bs.web.controller.xinx;

import org.bs.web.common.CommonConf;
import org.bs.web.pojo.movie.PaiQiSeatBean;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.SeatBean;
import org.bs.web.pojo.order.OrderMessage;
import org.bs.web.service.xinx.XinxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("xinx")
public class XinxController {


    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedisTemplate<String, String> redisTemplate2;

    @Autowired
    private XinxService xinxService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *      进入选座页面    将排期Id 带进页面
     * @param id        排期Id
     * @return
     */
    @RequestMapping("/page/toSeat")
    public String toSeat(Integer id, Model model, HttpSession session){

        Object attribute = session.getAttribute(session.getId());
        if (attribute == null){
            return "llp/view/login";
        }

        model.addAttribute("id",id);
        PaiqiBean paiqiInfoById = xinxService.findPaiqiInfoById(id);
        model.addAttribute("startTime",paiqiInfoById.getStartTime());
        Integer hallId = paiqiInfoById.getHallId();
        String hallName = xinxService.getHallName(hallId);
        model.addAttribute("hallName",hallName);
        return "xinx/seat/seat";
    }

    /**
     *      初始化页面
     * @param id
     * @return
     */
    @RequestMapping("init")
    @ResponseBody
    public Map<String,Object> init(Integer id){

        HashMap<String, Object> result = new HashMap<>();

        PaiqiBean paiqiBean = null;
        Boolean hasKey = redisTemplate.opsForHash().hasKey(CommonConf.PAI_QI_KEY, CommonConf.PAI_QI_KEY + id);
        if (hasKey) {
            paiqiBean = (PaiqiBean) redisTemplate.opsForHash().get(CommonConf.PAI_QI_KEY, CommonConf.PAI_QI_KEY + id);
        } else {
            paiqiBean = xinxService.findPaiqiInfoById(id);
        }

        List<SeatBean> seatBeans = new ArrayList<>();
        List<PaiQiSeatBean> paiQiSeatBeans = (List)redisTemplate.opsForHash().entries(CommonConf.PAI_QI_SEATS_KEY+paiqiBean.getId()).values().stream().collect(Collectors.toList());
        for (PaiQiSeatBean paiQiSeatBean : paiQiSeatBeans){
            //判断当前排期座位 状态是否为 已售
            if (paiQiSeatBean.getStatus() == 2){
                //判断是否未付款
                String s = redisTemplate2.opsForValue().get(paiQiSeatBean.getPaiQiId() + "-" + paiQiSeatBean.getSeatId());
                System.out.println(s);
                if (!"yes".equals(s)){
                    //如果没有未付款信息  判断是否已付款
                    Integer paiQiId = paiQiSeatBean.getPaiQiId();
                    System.out.println(paiQiId);
                    Integer seatId = paiQiSeatBean.getSeatId();
                    System.out.println(seatId);
                    String key = CommonConf.ORDER_NUM_KEK_P + paiQiId + CommonConf.ORDER_NUM_KEK_S + seatId;
                    System.out.println(key);
                    Object object =  redisTemplate.opsForHash().get(CommonConf.ORDER_NUM_KEK,key);
                    if (object == null)//如果也没有   将状态改为  可选
                        changeStatus(paiQiSeatBean.getPaiQiId(),""+paiQiSeatBean.getSeatId(),0);
                }

            }
            SeatBean seatBean = (SeatBean) redisTemplate.opsForHash().get(CommonConf.HALL_SEATS_KEY + paiqiBean.getHallId(), CommonConf.SEATS_INFO_KEY + paiQiSeatBean.getSeatId());
            paiQiSeatBean.setSeatBean(seatBean);
        }

        result.put("paiQiSeatBeans",paiQiSeatBeans);


        Integer hallType = xinxService.findHallType(paiqiBean.getHallId());

        result.put("hallType",hallType);

        return result;
    }

    @RequestMapping("changeStatus")
    @ResponseBody
    public Boolean changeStatus(Integer paiQiId,String seats,int flag){
        List<Integer> seatIds = Arrays.stream(seats.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        Boolean b = false;
        for (Integer seatId : seatIds){
            b = xinxService.changeStatus(paiQiId,seatId,flag);
        }

        return b;
    }


    @RequestMapping("test")
    @ResponseBody
    public Boolean test(String str,String o){
        try {
            redisTemplate.opsForHash().put(CommonConf.TIME,CommonConf.TIME+o,str);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
