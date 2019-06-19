package org.bs.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.PaiqiBean;
import org.bs.web.pojo.SeatBean;
import org.bs.web.pojo.rjf.ConsumerBean;
import org.bs.web.pojo.rjf.OrderMessage;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderMapper {

    OrderMessage queryOrderDetail(@Param("movieId") Integer movieId, @Param("hallId") Integer hallId,@Param("userId") Integer userId);

    //ConsumerBean queryConsumer(@Param("userId") Integer userId);

    @Select("select *  from t_seat where id = #{value}")
    SeatBean findSeatInfoById(Integer id);

    /*@Select("select *  from t_paiqi where id = #{value}")
    PaiqiBean queryPaiqi(@RequestParam("paiqiId") Integer paiqiId);*/
}
