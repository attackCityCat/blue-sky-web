package org.bs.web.controller.dyl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bs.web.pojo.HallBean;
import org.bs.web.pojo.SeatBean;
import org.bs.web.service.dyl.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dyl")
public class HallController {

    @Autowired
    private HallService hallService;


    //查看放映厅
    @RequestMapping("queryHall")
    public HallBean queryHall(){
        return hallService.queryHall();
    }

    //新增放映厅
    @RequestMapping("addHall")
    public Boolean addHall(HallBean hallBean){
        try{
            hallService.addHall(hallBean);
            hallBean.setId(hallService.queryHallId(hallBean.getName()));
            Integer id = hallService.queryHallId(hallBean.getName());
            System.out.println(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //查看放映厅座位
    @RequestMapping("querySeat")
    public SeatBean querySeat(Integer hallId){
            return hallService.querySeat(hallId);
    }

    //管理放映厅的座位等
    @RequestMapping("editSeat")
    public Boolean editSeat(SeatBean seatBean){
        try {
            hallService.editSeat(seatBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
