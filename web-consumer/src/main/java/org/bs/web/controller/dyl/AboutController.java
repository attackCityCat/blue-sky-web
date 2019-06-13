package org.bs.web.controller.dyl;

import org.bs.web.dyl.pojo.MovieAboutBean;
import org.bs.web.service.dyl.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dyl")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @RequestMapping("queryMovieByName")
    public MovieAboutBean queryMovieBynMame(String name){
        return aboutService.queryMovieByName(name);
    }




}
