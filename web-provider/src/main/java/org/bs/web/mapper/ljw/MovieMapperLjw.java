package org.bs.web.mapper.ljw;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bs.web.pojo.movie.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lenovo
 * @title: MovieMapperLjw
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1411:01
 */
@Mapper
public interface MovieMapperLjw {

    @Select("select count(1) " +
            " from t_movie tm " +
            " left join t_movie_detail tmd on tmd.movieId = tm.id " +
            " left join t_movie_time tmt on tmt.movieId = tm.id " +
            " left join t_paiqi tp on tp.movieId = tm.id " +
            " left join t_movie_type tmty on tmty.id = tmd.type " +
            " left join t_movie_language tml on tml.id = tmd.language")
    Integer queryMovieCountLjw(HashMap<String, Object> map);

    List<MovieBean> queryMovieLjw(HashMap<String, Object> map);

    Boolean saveMovieLjw(MovieBean movieBean);

    void saveDetailLjw(MovieBean movieBean);

    @Select("select * from t_movie_language")
    List<LanguageBean> getLanguageLjw();

    @Select("select * from t_movie_type")
    List<MovieTypeBean> getTypeLjw();

    void saveMovieTypeLjw(MovieTypeBean movieTypeBean);

    void saveLanguageLjw(LanguageBean languageBean);

    void saveMovieTime(MovieTimeBean movieTimeBean);

    @Select("select * from t_movie_type where name = #{value}")
    MovieTypeBean queryTypeByNameLjw(String typeName);

    @Select("select * from t_movie_language where name = #{value}")
    LanguageBean queryLanguageByNameLjw(String languageName);

    @Select("select * from t_performer")
    List<PerformerBean> getPerformerLjw();

    @Select("select * from t_tag")
    List<TagBean> getTagLjw();

    void saveTagLjw(TagBean tagBean);

    @Select("select * from t_tag where name  = #{value}")
    TagBean queryTagByName(String tag);

    void saveMovieTag(ArrayList<MovieTagBean> list);

    @Select("select * from t_performer where name = #{value}")
    PerformerBean queryPerformerByName(String performer);

    void savePerformerLjw(PerformerBean performerBean1);

    void saveMoviePerformer(ArrayList<MoviePerformerBean> arrayList);

    @Select("select  " +
            "  GROUP_CONCAT(tt.name) tag  " +
            "  from t_movie tm  " +
            "  left join t_movie_tag tmt on tmt.movieId = tm.id  " +
            "  left join t_tag tt on tt.id = tmt.tagId  " +
            "  where tm.id = #{value}  " +
            "  group by tm.id")
    String queryTagLjw(Integer movieId);

    @Update("update t_movie set slideShow = 1 where id = #{value}")
    void isSlideShowLjw(Integer id);

    @Update("update t_movie set slideShow = 0 where id = #{value}")
    void noSlideShowLjw(Integer id);
}
