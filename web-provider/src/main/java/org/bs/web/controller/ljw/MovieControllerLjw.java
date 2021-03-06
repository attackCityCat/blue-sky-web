package org.bs.web.controller.ljw;


import org.bs.web.common.CommonConf;
import org.bs.web.mapper.ljw.MovieMapperLjw;
import org.bs.web.dao.ljw.MovieRepository;
import org.bs.web.pojo.HitMovies;
import org.bs.web.pojo.movie.*;
import org.bs.web.util.PageModel;
import org.bs.web.util.ResultUtil;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lenovo
 * @title: MovieController
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1411:00
 */
@RestController
@Transactional
public class MovieControllerLjw {

    @Autowired
    private MovieMapperLjw movieMapperLjw;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    //设置为轮播图
    @RequestMapping(value = "/isSlideShowLjw")
    public void isSlideShowLjw(@RequestParam(value = "id") Integer id){

        int i = movieMapperLjw.isSlideShowLjw(id);

        if (i > 0){
            HitMovies hitMovies = movieMapperLjw.findImgInfoById(id);
            redisTemplate.opsForHash().put(CommonConf.IMGS_KEY,CommonConf.IMGS_KEY+id,hitMovies);
        }


    }

    //取消设置为轮播图
    @RequestMapping(value = "/noSlideShowLjw")
    public void noSlideShowLjw(@RequestParam(value = "id") Integer id){
        int i = movieMapperLjw.noSlideShowLjw(id);
        if (i > 0){
            redisTemplate.opsForHash().delete(CommonConf.IMGS_KEY,CommonConf.IMGS_KEY+id);
        }
    }

    //动态加载标签
    @RequestMapping(value = "/getTagLjw")
    public List<TagBean> getTagLjw(){
        return movieMapperLjw.getTagLjw();
    }

    //动态加载演员
    @RequestMapping(value = "/getPerformerLjw")
    public List<PerformerBean> getPerformerLjw(){
        return movieMapperLjw.getPerformerLjw();
    }

    //动态加载type
    @RequestMapping(value = "/getTypeLjw")
    public List<MovieTypeBean> getTypeLjw(){
        return movieMapperLjw.getTypeLjw();
    }

    //动态加载language
    @RequestMapping(value = "/getLanguageLjw")
    public List<LanguageBean> getLanguageLjw(){
        return movieMapperLjw.getLanguageLjw();
    }

    //新增
    @RequestMapping(value = "/saveMovieLjw")
    public void saveMovieLjw(@RequestBody MovieBean movieBean){
        //拼接首映时间
        String firstDate = movieBean.getStartDate().concat(" "+movieBean.getFirstTime());
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String format = sim.format(firstDate);
        movieBean.setFirstTime(firstDate);
        //增电影
        Boolean a = movieMapperLjw.saveMovieLjw(movieBean);

        //判断新增是否成功 如果成功  将  id , name , img , status  缓存至redis
        if (a==true){
            String movieKey = "movieKey";
            redisTemplate.opsForList().leftPush(movieKey,movieBean);
        }



        //根据name去数据库查类型
        MovieTypeBean movieType = movieMapperLjw.queryTypeByNameLjw(movieBean.getTypeName());
        if (movieType==null){
            //增类型
            MovieTypeBean movieTypeBean = new MovieTypeBean();
            movieTypeBean.setName(movieBean.getTypeName());
            movieMapperLjw.saveMovieTypeLjw(movieTypeBean);
            movieBean.setType(movieTypeBean.getId());
        }else{
            movieBean.setType(movieType.getId());
        }


        //根据name去数据库查语言
        LanguageBean language = movieMapperLjw.queryLanguageByNameLjw(movieBean.getLanguageName());
        if (language==null){
            //增语言
            LanguageBean languageBean = new LanguageBean();
            languageBean.setName(movieBean.getLanguageName());
            movieMapperLjw.saveLanguageLjw(languageBean);
            movieBean.setLanguage(languageBean.getId());
        }else{
            movieBean.setLanguage(language.getId());
        }

        //新增tag
        String[] tags = movieBean.getTag().split(",");
        ArrayList<MovieTagBean> list = new ArrayList<>();
        //遍历截取的数组
        for(int j=0;j<tags.length;j++){
            //每循环一次去查一次
            TagBean tagBean1 = movieMapperLjw.queryTagByName(tags[j]);
            //中间表
            MovieTagBean movieTagBean = new MovieTagBean();
            //标签表
            TagBean tagBean = new TagBean();
            //首先判断数据库有没有这个数据
            if (tagBean1 == null){
                //没有的话就把传过来的数据放到标签bean里
                tagBean.setName(tags[j]);
                movieMapperLjw.saveTagLjw(tagBean);
                //没有的话就获取刚新增返回的id
                movieTagBean.setTagId(tagBean.getId());
            }else{
                //有的话就直接获取id就ok了
                movieTagBean.setTagId(tagBean1.getId());
            }
            movieTagBean.setMovieId(movieBean.getId());
            list.add(movieTagBean);
        }
        //增到中间表里
        movieMapperLjw.saveMovieTag(list);

        //新增performer
        String[] performers = movieBean.getPerformer().split(",");
        ArrayList<MoviePerformerBean> arrayList = new ArrayList<>();
        //遍历截取的数组
        for(int i=0;i<performers.length;i++){
            //每循环一次去查一次
            PerformerBean performerBean = movieMapperLjw.queryPerformerByName(performers[i]);
            //中间表
            MoviePerformerBean moviePerformerBean = new MoviePerformerBean();

            //演员表
            PerformerBean performerBean1 = new PerformerBean();
            //首先判断数据库有没有这个数据
            if (performerBean == null){
                //没有的话就把传过来的数据放到标签bean里
                performerBean1.setName(performers[i]);
                movieMapperLjw.savePerformerLjw(performerBean1);
                //没有的话就获取刚新增返回的id
                moviePerformerBean.setPerformerId(performerBean1.getId());
            }else{
                //有的话就直接获取id就ok了
                moviePerformerBean.setPerformerId(performerBean.getId());
            }
            moviePerformerBean.setMovieId(movieBean.getId());
            arrayList.add(moviePerformerBean);
        }
        //增到中间表里
        movieMapperLjw.saveMoviePerformer(arrayList);

        //增电影详情
        movieMapperLjw.saveDetailLjw(movieBean);


        //增电影时间
        MovieTimeBean movieTimeBean = new MovieTimeBean();
        movieTimeBean.setStartDate(movieBean.getStartDate());
        movieTimeBean.setEndDate(movieBean.getEndDate());
        movieTimeBean.setMovieId(movieBean.getId());
        movieMapperLjw.saveMovieTime(movieTimeBean);

        MovieBean MovieInfo = movieMapperLjw.findMovieInfo(movieBean.getId());
        String tag = movieMapperLjw.queryTagLjw(movieBean.getId());
        MovieInfo.setTag(tag);
        //新增索引
        movieRepository.save(MovieInfo);
   }

    //查询
    @RequestMapping(value = "/queryMovieLjw")
    public ResultUtil queryMovieLjw(@RequestParam(value = "page") Integer page,
                                    @RequestParam(value = "rows") Integer rows,
                                    @RequestBody MovieBean movieBean){
        ResultUtil resultUtil = new ResultUtil();
        HashMap<String, Object> map = new HashMap<>();
        map.put("movieBean",movieBean);
        Integer sum = movieMapperLjw.queryMovieCountLjw(map);
        PageModel model = new PageModel(sum, page, rows);
        Integer start = model.getFirstResultCount();
        Integer end = model.getLastResultCount();
        map.put("start",start);
        map.put("end",end);
        List<MovieBean> list = movieMapperLjw.queryMovieLjw(map);
        for (int i = 0; i < list.size(); i++) {
            Integer movieId = list.get(i).getId();
            String tag = movieMapperLjw.queryTagLjw(movieId);
            list.get(i).setTag(tag);
        }
        resultUtil.setRows(list);
        resultUtil.setTotal(sum);
        return resultUtil;
    }
}
