package org.bs.web.mapper.dyl;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bs.web.pojo.HallBean;
import org.bs.web.pojo.HallTypeBean;
import org.bs.web.pojo.SeatBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HallMapper {


    @Insert("insert into t_hall(name,typeId) values(#{name},#{typeId})")
    void addHoll(HallBean hallBean);

    @Select("select th.id,th.name,th.typeId,tht.name as typeName,tht.seats from t_hall th left join t_hall_type tht on th.typeId = tht.id")
    List<HallBean> queryHall();

    @Select("select * from t_seat where hallId = #{value}")
    List<SeatBean> querySeat(Integer hallId);

    @Update("update t_seat set seatColumn =#{seatColumn},seatRow = #{seatRow},isActive = #{isActive},isLovers = #{isLovers} where hallId = #{hallId}")
    void editSeat(SeatBean seatBean);


    @Select("select id from t_hall where name = #{value}")
    Integer queryHallId(String name);

    @Select("select tht.seats from t_hall th left join t_hall_type tht on th.typeId = tht.id where th.id = #{value}")
    Integer queryHallCount(Integer hellSeatId);

    @Select("select count(*) from t_seat where hallId = #{value}")
    Integer querySeatCount(Integer hellSeatId);

    @Select("select * from t_seat where seatRow = #{row} and hallId = #{hallId}")
    List<SeatBean> queryRowCount(String row,Integer hallId);


    @Insert("insert into t_seat(hallId,seatRow,seatColumn) values(#{hallSeatId},#{seatBean.seatRow},#{seatBean.seatColumn})")
    void addSeat(SeatBean seatBean,Integer hallSeatId);

    @Select("select th.id,th.name,th.typeId,tht.name as typeName,tht.seats from t_hall th left join t_hall_type tht on th.typeId = tht.id where th.id = #{value}")
    List<HallBean> queryHallById(Integer id);

    @Select("select * from t_hall_type")
    List<HallTypeBean> queryHallType();
}
