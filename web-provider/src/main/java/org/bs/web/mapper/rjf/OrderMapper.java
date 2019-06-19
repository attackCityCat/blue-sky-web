package org.bs.web.mapper.rjf;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.movie.SeatBean;
import org.bs.web.pojo.order.ConsumerBean;
import org.bs.web.pojo.order.OrderMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public interface OrderMapper {

    OrderMessage queryOrderDetail(Integer paiQiId);

    //ConsumerBean queryConsumer(@Param("userId") Integer userId);

    @Select("select *  from t_seat where id = #{value}")
    SeatBean findSeatInfoById(Integer id);

    /*@Select("select *  from t_paiqi where id = #{value}")
    PaiqiBean queryPaiqi(@RequestParam("paiqiId") Integer paiqiId);*/
}
