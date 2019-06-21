package org.bs.web.service.xinx;

import org.bs.web.pojo.movie.PaiQiSeatBean;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.SeatBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface XinxServiceApi {

    @RequestMapping("/xinx/findSeatListByHallId")
    public List<SeatBean> findSeatListByHallId(@RequestParam("hallId") Integer hallId);

    @RequestMapping("/xinx/findHallType")
    public Integer findHallType(@RequestParam("hallId") Integer hallId);

    @RequestMapping("/xinx/findPaiqiInfoById")
    public PaiqiBean findPaiqiInfoById(@RequestParam("id") Integer id);

    @RequestMapping("/xinx/changeStatus")
    Boolean changeStatus(@RequestParam(value = "paiQiId") Integer paiQiId,@RequestParam(value = "seatId") Integer seatId,@RequestParam(value = "flag") int flag);

    @RequestMapping("/xinx/getHallName")
    String getHallName(@RequestParam("hallId") Integer hallId);
}
