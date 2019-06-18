package org.bs.web.mapper.xinx;

import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.movie.PaiqiBean;
import org.springframework.stereotype.Component;

@Component
public interface XinxMapper {


    @Select("SELECT th.typeId from t_hall th where th.id = #{value}")
    Integer findHallType(Integer hallId);

    @Select("SELECT * from t_paiqi where  id = #{value}")
    PaiqiBean findPaiqiInfoById(Integer id);
}
