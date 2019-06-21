package org.bs.web.controller.xinx;

import org.bs.web.common.CommonConf;
import org.bs.web.mapper.hyd.MovieMapper;
import org.bs.web.mapper.xinx.XinxMapper;
import org.bs.web.pojo.HitMovies;
import org.bs.web.pojo.movie.PaiQiSeatBean;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.SeatBean;
import org.bs.web.pojo.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("xinx")
public class XinxController {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private XinxMapper xinxMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("findSeatListByHallId")
    public List<SeatBean> findSeatListByHallId(@RequestParam("hallId") Integer hallId){
        return movieMapper.findSeatListByHallId(hallId);
    }

    @RequestMapping("findHallType")
    public Integer findHallType(@RequestParam("hallId") Integer hallId){
        return xinxMapper.findHallType(hallId);
    };

    @RequestMapping("findPaiqiInfoById")
    public PaiqiBean findPaiqiInfoById(@RequestParam("id") Integer id){
        return xinxMapper.findPaiqiInfoById(id);
    };

    @RequestMapping("changeStatus")
    public Boolean changeStatus(@RequestParam(value = "paiQiId") Integer paiQiId,@RequestParam(value = "seatId") Integer seatId,@RequestParam(value = "flag") int flag){

        try {
            PaiQiSeatBean paiQiSeatBean = new PaiQiSeatBean();

            paiQiSeatBean.setPaiQiId(paiQiId);
            paiQiSeatBean.setSeatId(seatId);
            paiQiSeatBean.setStatus(flag);

            redisTemplate.opsForHash().put(CommonConf.PAI_QI_SEATS_KEY+paiQiId,CommonConf.PAI_QI_SEATS_KEY+seatId,paiQiSeatBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    };


    @RequestMapping("/saveOrderStatus")
    public Boolean saveOrderStatus(OrderStatus orderStatus){
        OrderStatus save = mongoTemplate.save(orderStatus);
        return save != null;
    }

    @RequestMapping("/getHallName")
    String getHallName(@RequestParam("hallId") Integer hallId){
        return xinxMapper.getHallName(hallId);
    };


}
