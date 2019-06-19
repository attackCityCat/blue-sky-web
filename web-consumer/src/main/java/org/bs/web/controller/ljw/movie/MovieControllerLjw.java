package org.bs.web.controller.ljw.movie;

import org.bs.web.pojo.MovieBean;
import org.bs.web.pojo.movie.LanguageBean;
import org.bs.web.pojo.movie.MovieTypeBean;
import org.bs.web.pojo.movie.PerformerBean;
import org.bs.web.pojo.movie.TagBean;
import org.bs.web.service.ljw.MovieService;
import org.bs.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author Lenovo
 * @title: MovieController
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1322:40
 */
@Controller
@RequestMapping(value = "/movie")
public class MovieControllerLjw {

    @Autowired
    private MovieService movieService;

    //动态加载标签
    @RequestMapping(value = "/getTagLjw")
    @ResponseBody
    public List<TagBean> getTagLjw(){
        return movieService.getTagLjw();
    }

    //动态加载演员
    @RequestMapping(value = "/getPerformerLjw")
    @ResponseBody
    public List<PerformerBean> getPerformerLjw(){
        return movieService.getPerformerLjw();
    }

    //动态加载type
    @RequestMapping(value = "/getTypeLjw")
    @ResponseBody
    public List<MovieTypeBean> getTypeLjw(){
        return movieService.getTypeLjw();
    }

    //动态加载language
    @RequestMapping(value = "/getLanguageLjw")
    @ResponseBody
    public List<LanguageBean> getLanguageLjw(){
        return movieService.getLanguageLjw();
    }

    //新增
    @RequestMapping(value = "/saveMovieLjw")
    @ResponseBody
    public void saveMovieLjw(MovieBean movieBean){
        movieService.saveMovieLjw(movieBean);
    }

    //查询
    @RequestMapping(value = "/queryMovieLjw")
    @ResponseBody
    public ResultUtil queryMovieLjw(Integer page,Integer rows,MovieBean movieBean){
        return movieService.queryMovieLjw(page,rows,movieBean);
    }

    /*//图片上传
    @RequestMapping("uploadNewsImg")
    @ResponseBody
    public String uploadNewsImg(MultipartFile img, HttpServletRequest request) throws IOException {
        String path = FileUtil.uploadFile(img, request);
        return path;
    }*/

}
