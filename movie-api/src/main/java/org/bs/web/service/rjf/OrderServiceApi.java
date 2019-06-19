package org.bs.web.service.rjf;

import org.bs.web.pojo.rjf.OrderMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderServiceApi {

    //查询关于订单信息
    @RequestMapping(value = "/queryOrderRJF",method = RequestMethod.GET)
    OrderMessage queryOrderDetail(@RequestParam("phone") String phone,@RequestParam("paiqiId") Integer paiqiId,@RequestParam("userId") Integer userId,@RequestParam("seatIds") Integer[] seatIds);

    @RequestMapping("/saveOrderRJF")
    void saveOrder(@RequestParam("orderNum") String orderNum);

    @RequestMapping("/deleteOrderRJF")
    void deleteOrder(@RequestParam("orderNum") String orderNum);
}
