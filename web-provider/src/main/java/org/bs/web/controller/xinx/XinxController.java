package org.bs.web.controller.xinx;

import org.bs.web.mapper.hyd.MovieMapper;
import org.bs.web.mapper.xinx.XinxMapper;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.SeatBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("xinx")
public class XinxController {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private XinxMapper xinxMapper;

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
}
