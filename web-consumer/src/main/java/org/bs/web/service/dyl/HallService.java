package org.bs.web.service.dyl;

import org.bs.web.pojo.HallBean;
import org.bs.web.pojo.SeatBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "web-provider")
public interface HallService {

    @RequestMapping(value = "/addHall")
    Boolean addHall(@RequestBody HallBean hallBean);

    @RequestMapping(value = "/queryHall")
    HallBean queryHall();

    @RequestMapping(value = "/querySeat")
    SeatBean querySeat(@RequestParam(value = "hallId") Integer hallId);

    @RequestMapping(value = "/editSeat")
    Boolean editSeat(@RequestBody SeatBean seatBean);


    @RequestMapping(value = "/queryHallId")
    Integer queryHallId(@RequestParam(value = "name") String name);

}
