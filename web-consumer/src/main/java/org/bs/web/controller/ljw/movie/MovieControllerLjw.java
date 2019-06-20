package org.bs.web.controller.ljw.movie;

import org.bs.web.dao.ljw.MovieRepository;
import org.bs.web.pojo.movie.MovieBean;
import org.bs.web.pojo.movie.LanguageBean;
import org.bs.web.pojo.movie.MovieTypeBean;
import org.bs.web.pojo.movie.PerformerBean;
import org.bs.web.pojo.movie.TagBean;
import org.bs.web.service.ljw.MovieServiceLjw;
import org.bs.web.util.ResultUtil;
import org.bs.web.utils.ljw.OssClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Lenovo
 * @title: MovieController
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1322:40
 */
@RestController
@RequestMapping(value = "/movie")
public class MovieControllerLjw {

    @Autowired
    private MovieServiceLjw movieService;

    @Autowired
    private MovieRepository movieRepository;



    //取消设置为轮播图
    @RequestMapping(value = "/noSlideShowLjw")
    public void noSlideShowLjw(Integer id){
        movieService.noSlideShowLjw(id);
    }

    //设置为轮播图
    @RequestMapping(value = "/isSlideShowLjw")
    public void isSlideShowLjw(Integer id){
        movieService.isSlideShowLjw(id);
    }

    //删除es索引
    @RequestMapping("deleteMovieByIdLjw")
    public Boolean deleteMovieByIdLjw(Integer id){
        try {
            //先对数据库进行删除，然后判断是否删除成功，如果删除成功，在对索引进行删除，为了保证数据的一致性
            movieRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //动态加载标签
    @RequestMapping(value = "/getTagLjw")
    public List<TagBean> getTagLjw(){
        return movieService.getTagLjw();
    }

    //动态加载演员
    @RequestMapping(value = "/getPerformerLjw")
    public List<PerformerBean> getPerformerLjw(){
        return movieService.getPerformerLjw();
    }

    //动态加载type
    @RequestMapping(value = "/getTypeLjw")
    public List<MovieTypeBean> getTypeLjw(){
        return movieService.getTypeLjw();
    }

    //动态加载language
    @RequestMapping(value = "/getLanguageLjw")
    public List<LanguageBean> getLanguageLjw(){
        return movieService.getLanguageLjw();
    }

    //新增
    @RequestMapping(value = "/saveMovieLjw")
    public void saveMovieLjw(MovieBean movieBean){
        movieService.saveMovieLjw(movieBean);
    }

    //查询
    @RequestMapping(value = "/queryMovieLjw")
    public ResultUtil queryMovieLjw(Integer page,Integer rows,MovieBean movieBean){
        return movieService.queryMovieLjw(page,rows,movieBean);
    }

    //图片上传
    @RequestMapping("uploadNewsImg")
    public String uploadNewsImg(MultipartFile img) throws IOException {
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OssClientUtil ossClient=new OssClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return "{\"path\":\"" + split[0] + "\"}";
    }

}
