package org.bs.web.service.dyl;

import org.bs.web.pojo.HallBean;
import org.bs.web.pojo.SeatBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "web-provider")
public interface HallService {

    @RequestMapping(value = "/addHall")
    Boolean addHall(@RequestBody HallBean hallBean);

    @RequestMapping(value = "/queryHall")
    List<HallBean> queryHall();

    @RequestMapping(value = "/querySeat")
    SeatBean querySeat(@RequestParam(value = "hallId") Integer hallId);

    @RequestMapping(value = "/editSeat")
    Boolean editSeat(@RequestBody SeatBean seatBean);


    @RequestMapping(value = "/queryHallId")
    Integer queryHallId(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/queryHallCount")
    Integer queryHallCount(@RequestParam(value = "hellSeatId") Integer hellSeatId);

    @RequestMapping(value = "/querySeatCount")
    Integer querySeatCount(@RequestParam(value = "hellSeatId") Integer hellSeatId);

    @RequestMapping(value = "/queryColumnCount")
    Integer queryColumnCount(@RequestParam(value = "column") String column);

    @RequestMapping(value = "/addSeat")
    Boolean addSeat(@RequestBody SeatBean seatBean,@RequestParam(value = "hallId")Integer hallSeatId);

    @RequestMapping(value = "/queryRowCount")
    List<SeatBean> queryRowCount(@RequestParam(value = "row") String row,@RequestParam(value = "hallId") Integer hallId);

    @RequestMapping(value = "/queryHallById")
    List<HallBean> queryHallById(@RequestParam(value = "id") Integer id);
}
