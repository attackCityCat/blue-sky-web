package org.bs.web.controller.ljw;

import org.bs.web.mapper.ljw.MovieMapper;
import org.bs.web.pojo.movie.*;
import org.bs.web.util.PageModel;
import org.bs.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lenovo
 * @title: MovieController
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1411:00
 */
@Controller
@Transactional
public class MovieController {

    @Autowired
    private MovieMapper movieMapper;

    //动态加载标签
    @RequestMapping(value = "/getTagLjw")
    @ResponseBody
    public List<TagBean> getTagLjw(){
        return movieMapper.getTagLjw();
    }

    //动态加载演员
    @RequestMapping(value = "/getPerformerLjw")
    @ResponseBody
    public List<PerformerBean> getPerformerLjw(){
        return movieMapper.getPerformerLjw();
    }

    //动态加载type
    @RequestMapping(value = "/getTypeLjw")
    @ResponseBody
    public List<MovieTypeBean> getTypeLjw(){
        return movieMapper.getTypeLjw();
    }

    //动态加载language
    @RequestMapping(value = "/getLanguageLjw")
    @ResponseBody
    public List<LanguageBean> getLanguageLjw(){
        return movieMapper.getLanguageLjw();
    }

    //新增
    @RequestMapping(value = "/saveMovieLjw")
    @ResponseBody
    public void saveMovieLjw(@RequestBody MovieBean movieBean){
        //增电影
        movieMapper.saveMovieLjw(movieBean);

        //判断新增是否成功 如果成功  将  id , name , img , status  缓存至redis

        //新增索引


        //根据name去数据库查类型
        MovieTypeBean movieType = movieMapper.queryTypeByNameLjw(movieBean.getTypeName());
        if (movieType==null){
            //增类型
            MovieTypeBean movieTypeBean = new MovieTypeBean();
            movieTypeBean.setName(movieBean.getTypeName());
            movieMapper.saveMovieTypeLjw(movieTypeBean);
            movieBean.setType(movieTypeBean.getId());
        }else{
            movieBean.setType(movieType.getId());
        }


        //根据name去数据库查语言
        LanguageBean language = movieMapper.queryLanguageByNameLjw(movieBean.getLanguageName());
        if (language==null){
            //增语言
            LanguageBean languageBean = new LanguageBean();
            languageBean.setName(movieBean.getLanguageName());
            movieMapper.saveLanguageLjw(languageBean);
            movieBean.setLanguage(languageBean.getId());
        }else{
            movieBean.setLanguage(language.getId());
        }


        //新增tag
        String[] tags = movieBean.getTag().split(",");
        ArrayList<MovieTagBean> list = new ArrayList<>();
        for(int j=0;j<tags.length;j++){
            System.out.println(tags[j]+"22222222222222222");
            TagBean tagBean1 = movieMapper.queryTagByName(tags[j]);
            MovieTagBean movieTagBean = new MovieTagBean();
            TagBean tagBean = new TagBean();
            //首先判断数据库有没有这个数据
            if (tagBean1 == null){
                //新增标签
                //tag就是截取后的每个数据

                tagBean.setName(tags[j]);
                movieMapper.saveTagLjw(tagBean);
                movieTagBean.setTagId(tagBean.getId());
            }else{
                movieTagBean.setTagId(tagBean1.getId());
            }
            movieTagBean.setMovieId(movieBean.getId());
            list.add(movieTagBean);
        }
        movieMapper.saveMovieTag(list);

        //增电影详情
        movieMapper.saveDetailLjw(movieBean);


        //增电影时间
        MovieTimeBean movieTimeBean = new MovieTimeBean();
        movieTimeBean.setStartDate(movieBean.getStartDate());
        movieTimeBean.setEndDate(movieBean.getEndDate());
        movieTimeBean.setMovieId(movieBean.getId());
        movieMapper.saveMovieTime(movieTimeBean);
   }

    //查询
    @RequestMapping(value = "/queryMovieLjw")
    @ResponseBody
    public ResultUtil queryMovieLjw(@RequestParam(value = "page") Integer page,
                                    @RequestParam(value = "rows") Integer rows,
                                    @RequestBody MovieBean movieBean){
        ResultUtil resultUtil = new ResultUtil();
        HashMap<String, Object> map = new HashMap<>();
        map.put("movieBean",movieBean);
        Integer sum = movieMapper.queryMovieCountLjw(map);
        PageModel model = new PageModel(sum, page, rows);
        Integer start = model.getFirstResultCount();
        Integer end = model.getLastResultCount();
        map.put("start",start);
        map.put("end",end);
        List<MovieBean> list = movieMapper.queryMovieLjw(map);
        resultUtil.setRows(list);
        resultUtil.setTotal(sum);
        return resultUtil;
    }
}
