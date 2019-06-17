package org.bs.web.controller.dyl;

import org.bs.web.mapper.dyl.HallMapper;
import org.bs.web.pojo.HallBean;
import org.bs.web.pojo.SeatBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HallController {

    @Autowired
    private HallMapper hallMapper;

    @RequestMapping(value = "/addHall")
    public Boolean addHall(@RequestBody HallBean hallBean) {
        try {
            hallMapper.addHoll(hallBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/queryHall")
    public HallBean queryHall(){
        return hallMapper.queryHall();
    }

    @RequestMapping(value = "/querySeat")
    public SeatBean querySeat(@RequestParam(value = "hallId") Integer hallId){
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
