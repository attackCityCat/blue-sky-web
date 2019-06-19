package org.bs.web.controller.dyl;


import org.bs.web.mapper.dyl.AbooutMapper;
import org.bs.web.pojo.movie.MovieBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AboutController {

    @Autowired
    private AbooutMapper abooutMapper;


    @RequestMapping(value="/queryMovieByName/{name}")
    public MovieBean queryMovieBynMame(@RequestParam(value="name")String name){
        return abooutMapper.queryMovieByName(name);
    }

    @RequestMapping("queryMovie")
    public List<MovieBean> queryMMovie(){
        return abooutMapper.queryMovie();
    }


}
