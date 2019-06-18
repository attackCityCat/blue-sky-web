package org.bs.web.mapper.dyl;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bs.web.pojo.movie.HallBean;
import org.bs.web.pojo.movie.SeatBean;
import org.springframework.stereotype.Component;

@Component
public interface HallMapper {


    @Insert("insert into t_hall(name,typeId) values(#{name},#{typeId})")
    void addHoll(HallBean hallBean);

    @Select("select th.id,th.name,th.typeId,tht.name as typeName,tht.seats from t_hall th left join t_hall_type tht on th.typeId = tht.id")
    HallBean queryHall();

    @Select("select * from t_seat where hallId = #{value}")
    SeatBean querySeat(Integer hallId);

    @Update("update t_seat set column =#{column},row = #{row},isActive = #{isActive},isLovers = #{isLovers} where hallId = #{hallId}")
    void editSeat(SeatBean seatBean);


    @Select("select id from t_hall where name = #{value}")
    Integer queryHallId(String name);
}
