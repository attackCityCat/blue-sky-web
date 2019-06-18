package org.bs.web.controller.dyl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bs.web.pojo.HallBean;
import org.bs.web.pojo.HallTypeBean;
import org.bs.web.pojo.SeatBean;
import org.bs.web.service.dyl.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dyl")
public class HallController {

    @Autowired
    private HallService hallService;


    //查看放映厅
    @RequestMapping("queryHall")
    public List<HallBean> queryHall(){
        return hallService.queryHall();
    }

    //根据id查看放映厅
    @RequestMapping("queryHallById")
    public List<HallBean> queryHallById(Integer id){
        return hallService.queryHallById(id);
    }

    //查询放映厅类型
    @RequestMapping("queryHallType")
    public List<HallTypeBean> queryHallType(){
        return hallService.queryHallType();
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
    public List<SeatBean> querySeat(Integer hallId){
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

    //新增座位
    @RequestMapping("addSeat")
    public Boolean addSeat(Integer hellSeatId,SeatBean seatBean){
        String row = seatBean.getSeatRow();
        String column = seatBean.getSeatColumn();
        Integer SeatId = hellSeatId;
        System.out.println("===放映厅id==="+SeatId);
        Integer hallCount = hallService.queryHallCount(SeatId);
        System.out.println("===放映厅默认座位总数==="+hallCount);
        Integer seatCount = hallService.querySeatCount(SeatId);
        System.out.println("===放映厅已新增座位数量=="+seatCount);
        if(hallCount>seatCount){
            if(row != null && !"".equals(row)){
                 List<SeatBean> seatBean1 =hallService.queryRowCount(row,SeatId);
                if (seatBean1.size() != 0 ){
                    if(column != null && !"".equals(column)){
                        for (int i = 0;i < seatBean1.size();i++){
                            if (seatBean1.get(i).getSeatColumn().equals(column)){
                                return false;
                            }else {
                                try {
                                    hallService.addSeat(seatBean,SeatId);
                                    return true;
                                }catch (Exception e){
                                    e.printStackTrace();
                                    return false;
                                }
                            }
                        }
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    hallService.addSeat(seatBean,SeatId);
                    return true;
                }
            }else {
                return false;
            }
        }else{
            return false;
        }

    }
}
