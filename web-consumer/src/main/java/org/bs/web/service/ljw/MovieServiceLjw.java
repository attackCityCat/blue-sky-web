package org.bs.web.service.ljw;


import org.bs.web.pojo.movie.MovieBean;
import org.bs.web.pojo.movie.LanguageBean;
import org.bs.web.pojo.movie.MovieTypeBean;
import org.bs.web.pojo.movie.PerformerBean;
import org.bs.web.pojo.movie.TagBean;
import org.bs.web.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Lenovo
 * @title: MovieServiceLjw
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1322:45
 */
@FeignClient(value = "web-provider")
public interface MovieServiceLjw {

    //查询
    @RequestMapping(value = "/queryMovieLjw")
    ResultUtil queryMovieLjw(@RequestParam(value = "page") Integer page,
                             @RequestParam(value = "rows") Integer rows,
                             @RequestBody MovieBean movieBean);

    //新增
    @RequestMapping(value = "/saveMovieLjw")
    void saveMovieLjw(@RequestBody MovieBean movieBean);

    //动态加载language
    @RequestMapping(value = "/getLanguageLjw")
    List<LanguageBean> getLanguageLjw();

    //动态加载type
    @RequestMapping(value = "/getTypeLjw")
    List<MovieTypeBean> getTypeLjw();

    //动态加载演员
    @RequestMapping(value = "/getPerformerLjw")
    List<PerformerBean> getPerformerLjw();

    //动态加载标签
    @RequestMapping(value = "/getTagLjw")
    List<TagBean> getTagLjw();

    //设置为轮播图
    @RequestMapping(value = "/isSlideShowLjw")
    void isSlideShowLjw(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/noSlideShowLjw")
    void noSlideShowLjw(@RequestParam(value = "id") Integer id);
}
