package org.bs.web.mapper.llp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bs.web.pojo.HitMovies;
import org.bs.web.pojo.UserBean;
import org.bs.web.pojo.YanYuan;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 用户登陆操作，根据手机号查询。
     * @param phone
     * @return
     */
    @Select(" SELECT * FROM t_user WHERE phoneNumber = #{value}  ")
    UserBean findByPhone(String phone);

    @Insert(" INSERT INTO t_user(phoneNumber,password,name) VALUES(#{phoneNumber},#{password},#{name}) ")
    void addUser(UserBean userBean);

    @Update(" UPDATE t_user  SET NAME = #{name} WHERE phoneNumber = #{phone} ")
    void updateUser(String name, String phone);

    @Select(" SELECT " +
            " tm.*, " +
            " tmd.price, " +
            " tmd.length, " +
            " GROUP_CONCAT( tag.NAME ) AS tagName " +
            "FROM " +
            " t_movie tm " +
            " LEFT JOIN t_movie_tag tmt ON tm.id = tmt.movieId " +
            " LEFT JOIN t_movie_detail tmd ON tm.id = tmd.movieId " +
            " LEFT JOIN t_tag tag ON tag.id = tmt.tagId  " +
            " WHERE " +
            " tm.STATUS = 0  " +
            " GROUP BY tm.id  LIMIT 15")
    List<HitMovies> findHitMovies();
    @Select(" SELECT " +
            " tm.*, " +
            " tmd.price, " +
            " tmd.length, " +
            " GROUP_CONCAT( tag.NAME ) AS tagName " +
            "FROM " +
            " t_movie tm " +
            " LEFT JOIN t_movie_tag tmt ON tm.id = tmt.movieId " +
            " LEFT JOIN t_movie_detail tmd ON tm.id = tmd.movieId " +
            " LEFT JOIN t_tag tag ON tag.id = tmt.tagId  " +
            " WHERE " +
            " tm.STATUS = 0  " +
            " GROUP BY tm.id  LIMIT 10")
    List<HitMovies> findHitMoviesMain();

    @Select(" SELECT " +
            " tm.*, " +
            " tmd.price, " +
            " tmd.length, " +
            " GROUP_CONCAT( tag.NAME ) AS tagName " +
            "FROM " +
            " t_movie tm " +
            " LEFT JOIN t_movie_tag tmt ON tm.id = tmt.movieId " +
            " LEFT JOIN t_movie_detail tmd ON tm.id = tmd.movieId " +
            " LEFT JOIN t_tag tag ON tag.id = tmt.tagId  " +
            " WHERE " +
            " tm.STATUS = 1  " +
            " GROUP BY tm.id  LIMIT 10")
    List<HitMovies> findNotHitMoviesMain();

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
}
