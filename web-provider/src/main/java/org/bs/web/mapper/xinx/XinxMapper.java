package org.bs.web.mapper.xinx;

import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.HitMovies;
import org.bs.web.pojo.movie.PaiqiBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface XinxMapper {


    @Select("SELECT th.typeId from t_hall th where th.id = #{value}")
    Integer findHallType(Integer hallId);

    @Select("SELECT * from t_paiqi where  id = #{value}")
    PaiqiBean findPaiqiInfoById(Integer id);

    @Select("select name from t_hall where id = #{value}")
    String getHallName(Integer hallId);


}
