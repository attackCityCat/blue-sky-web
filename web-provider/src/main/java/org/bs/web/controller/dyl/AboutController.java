package org.bs.web.controller.dyl;

import org.bs.web.dyl.pojo.MovieAboutBean;
import org.bs.web.mapper.dyl.AbooutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @Autowired
    private AbooutMapper abooutMapper;


    @RequestMapping(value="/queryMovieByName/{name}")
    public MovieAboutBean queryMovieBynMame(@RequestParam(value="name")String name){
        return abooutMapper.queryMovieByName(name);
    }


}
