package org.bs.web.mapper.dyl;

import org.apache.ibatis.annotations.Select;
import org.bs.web.dyl.pojo.MovieAboutBean;
import org.springframework.stereotype.Component;

@Component
public interface AbooutMapper {


    @Select("select tm.id as id,tm.name as name,tm.img as img,tm.status as status,tmd.director as director,tmd.length as length,tmd.language as language,tmd.price as price,tmd.detail as detail,tmd.firstTime as firstTime,tmp.performerId as performerId,tp.name as performerName " +
            "          from t_movie tm left join t_movie_detail tmd on tm.id = movieId " +
            "                          left join t_movie_performer tmp on tm.id = tmp.movieId " +
            "                          left join t_performer tp on tmp.performerId = tp.id " +
            " where tm.name = #{value}")
    MovieAboutBean queryMovieByName(String name);
}
