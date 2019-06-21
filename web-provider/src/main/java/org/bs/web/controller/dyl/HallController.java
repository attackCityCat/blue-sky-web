package org.bs.web.controller.dyl;

import org.bs.web.common.CommonConf;
import org.bs.web.mapper.dyl.HallMapper;
import org.bs.web.pojo.movie.HallBean;
import org.bs.web.pojo.movie.HallTypeBean;
import org.bs.web.pojo.movie.SeatBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HallController {

    @Autowired
    private HallMapper hallMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/addHall")
    public Boolean addHall(@RequestBody HallBean hallBean) {
        try {
            hallMapper.addHoll(hallBean);
            redisTemplate.opsForHash().put(CommonConf.SUM_SEATS_KEY,CommonConf.SUM_SEATS_KEY + hallBean.getId(),0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/queryHall")
    public List<HallBean> queryHall(){
        return hallMapper.queryHall();
    }

    @RequestMapping("queryHallById")
    public List<HallBean> queryHallById(@RequestParam(value = "id") Integer id){
        return hallMapper.queryHallById(id);
    }

    @RequestMapping(value = "/querySeat")
    public List<SeatBean> querySeat(@RequestParam(value = "hallId") Integer hallId){
            return hallMapper.querySeat(hallId);
    }

    @RequestMapping("/editSeat")
    public Boolean editSeat(@RequestBody SeatBean seatBean){
        try {
            hallMapper.editSeat(seatBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/queryHallId")
    public Integer queryHallId(@RequestParam(value = "name") String name){
        return hallMapper.queryHallId(name);
    }

    @RequestMapping(value = "/queryHallCount")
    public Integer queryHallCount(@RequestParam(value = "hellSeatId") Integer hellSeatId){
        return hallMapper.queryHallCount(hellSeatId);
    }

    @RequestMapping(value = "/querySeatCount")
    public Integer querySeatCount(@RequestParam(value = "hellSeatId") Integer hellSeatId){
        return hallMapper.querySeatCount(hellSeatId);
    }

    @RequestMapping(value = "/queryRowCount")
    public List<SeatBean> queryRowCount(@RequestParam(value = "row") String row,@RequestParam(value = "hallId") Integer hallId){
        return hallMapper.queryRowCount(row,hallId);
    }


    @RequestMapping("/addSeat")
    public Boolean addSeat(@RequestBody SeatBean seatBean,@RequestParam(value = "hallId")Integer hallSeatId){
        try {
            hallMapper.addSeat(seatBean,hallSeatId);
            System.out.println(hallSeatId);
            Boolean hasKey = redisTemplate.opsForHash().hasKey(CommonConf.SUM_SEATS_KEY, CommonConf.SUM_SEATS_KEY + hallSeatId);
            if (hasKey){
                int object = (int) redisTemplate.opsForHash().get(CommonConf.SUM_SEATS_KEY, CommonConf.SUM_SEATS_KEY + hallSeatId);
                redisTemplate.opsForHash().put(CommonConf.SUM_SEATS_KEY, CommonConf.SUM_SEATS_KEY + hallSeatId,object+1);
                return true;
            }
            redisTemplate.opsForHash().put(CommonConf.SUM_SEATS_KEY, CommonConf.SUM_SEATS_KEY + hallSeatId,1);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @RequestMapping("/queryHallType")
    public List<HallTypeBean> queryHallType(){
        return hallMapper.queryHallType();
    }




   // @RequestMapping(value = "/addSeat")
    //public Boolean addSeat(@RequestParam(value = "id") Integer id){
      //  try {
        //    hallMapper.addSeat(id);
          //  return true;
        //}catch (Exception e){
          //  e.printStackTrace();
            //return false;
        //}
   // }
}
