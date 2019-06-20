package org.bs.web.mapper.hyd;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.movie.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieMapper {
    int saveMovie(@RequestBody PaiqiBean paiqiBean);

    @Select("SELECT " +
            "tp.id,  " +
            "tp.startTime,  " +
            "tmd.language,  " +
            "tp.movieId,  " +
            "tp.hallId, " +
            "th.name as hallName, " +
            " tmd.price  " +
            "FROM  " +
            "t_paiqi tp  " +
            "LEFT JOIN t_movie_detail tmd ON tp.movieId = tmd.id " +
            "LEFT JOIN t_hall th ON tp.hallId = th.id " +
            "where DATE_FORMAT(tp.startTime,'%Y-%m-%d') = (SELECT str_to_date(#{movieDate}, '%Y-%m-%d') ) " +
            "and tp.movieId = #{movieId}")
    List<PaiqiBean> findMoviePaiqi(@RequestParam("movieDate") String movieDate,@RequestParam("movieId") Integer movieId);

    @Select("select * from t_business_time")
    BusinessTimeBean findBusinessTime();

    @Select("select * from t_movie_time where movieId = #{value}")
    MovieTimeBean findMovieTime(@RequestParam("movieId") Integer movieId);

    @Select("SELECT DATE_FORMAT(startTime,'%h:%m:%s') as startTime,movieId FROM t_paiqi  " +
            "where hallId = #{hallId}  " +
            "and DATE_FORMAT(startTime,'%Y-%m-%d') = (SELECT str_to_date(#{ymd}, '%Y-%m-%d'))")
    List<PaiqiBean> findHallOnPaiqi(@Param("hallId") Integer hallId,@Param("ymd") String ymd);

    @Select("SELECT tmd.length from t_movie tm left join t_movie_detail tmd on tmd.movieId = tm.id "+
           "where tm.id = #{value}")
    int findMovieLengthById(Integer movieId);

    @Select("select count(*)  from t_seat where hallId = #{value} and isActive = 0")
    int findSeatsCountByHallId(Integer hallId);

    @Select("select *  from t_seat where hallId = #{value} and isActive = 0")
    List<SeatBean> findSeatListByHallId(Integer hallId);

    @Select("select * from t_paiqi_normal_time")
    List<PaiqiNormalTimeBean> findPaiqiNormalTimeBean();

    @Select("SELECT coe from t_hall th left join t_hall_type tht on th.typeId = tht.id " +
            "where th.id = #{value}")
    Float findHallTypeCoeByHallId(Integer hallId);

    @Select("SELECT " +
            "tp.id,  " +
            "tp.startTime,  " +
            "tmd.language,  " +
            "tp.movieId,  " +
            "tp.hallId, " +
            "th.name as hallName, " +
            " tmd.price  " +
            "FROM  " +
            "t_paiqi tp  " +
            "LEFT JOIN t_movie_detail tmd ON tp.movieId = tmd.id " +
            "LEFT JOIN t_hall th ON tp.hallId = th.id " +
            "where  tp.movieId = #{movieId}")
    List<PaiqiBean> findPaiQiById(@RequestParam("id") Integer id);

    @Select(" SELECT " +
            " tm.*, " +
            " tmd.price, " +
            " tmd.detail, " +
            " tmd.length, " +
            " tmd.director, " +
            " tmtp.NAME AS typeName, " +
            " GROUP_CONCAT( tag.NAME ) AS tagName  " +
            "FROM " +
            " t_movie tm " +
            " LEFT JOIN t_movie_tag tmt ON tm.id = tmt.movieId " +
            " LEFT JOIN t_movie_detail tmd ON tm.id = tmd.movieId " +
            " LEFT JOIN t_tag tag ON tag.id = tmt.tagId " +
            " LEFT JOIN t_movie_type tmtp ON tmtp.id = tmd.type  " +
            "WHERE " +
            " tm.STATUS = 0  " +
            " AND tm.id = #{value}  " +
            "GROUP BY " +
            " tm.id  " +
            " LIMIT 10 ")
    HitMovies findMoviesDetail(int id);

    @Select(" SELECT " +
            "   GROUP_CONCAT( tp.NAME ) AS perName  " +
            " FROM " +
            " t_movie tm " +
            " LEFT JOIN t_movie_performer tmp ON tmp.movieId = tm.id " +
            " LEFT JOIN t_performer tp ON tp.id = tmp.performerId " +
            " WHERE " +
            " tm.STATUS = 0  and tm.id = #{value} " +
            " GROUP BY " +
            " tm.id  ")
    YanYuan findYanYuan(int id);

    @Select(" SELECT " +
            " tm.*, " +
            " tmd.price, " +
            " tmd.detail, " +
            " tmd.length, " +
            " tmd.director, " +
            " tmtp.NAME AS typeName, " +
            " GROUP_CONCAT( tag.NAME ) AS tagName  " +
            "FROM " +
            " t_movie tm " +
            " LEFT JOIN t_movie_tag tmt ON tm.id = tmt.movieId " +
            " LEFT JOIN t_movie_detail tmd ON tm.id = tmd.movieId " +
            " LEFT JOIN t_tag tag ON tag.id = tmt.tagId " +
            " LEFT JOIN t_movie_type tmtp ON tmtp.id = tmd.type  " +
            "WHERE " +
            " tm.STATUS = 0  " +
            "GROUP BY " +
            " tm.id  " +
            " LIMIT 5 ")
    List<HitMovies> findHitMovies();

    @Select("SELECT " +
            "tp.id,  " +
            "tp.startTime,  " +
            "tmd.language,  " +
            "tp.movieId,  " +
            "tp.hallId, " +
            "th.name as hallName, " +
            " tmd.price  " +
            "FROM  " +
            "t_paiqi tp  " +
            "LEFT JOIN t_movie_detail tmd ON tp.movieId = tmd.id " +
            "LEFT JOIN t_hall th ON tp.hallId = th.id " +
            "where DATE_FORMAT(tp.startTime,'%Y-%m-%d') = (SELECT str_to_date(#{time}, '%Y-%m-%d') ) " +
            "and tp.movieId = #{id}")
    List<PaiqiBean> findPaiqiByIdAndByTime(@RequestParam("id") Integer id, @RequestParam("time") String time);
}
