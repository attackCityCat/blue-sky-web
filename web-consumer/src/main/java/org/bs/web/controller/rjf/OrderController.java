package org.bs.web.controller.rjf;


import org.bs.web.pojo.SeatBean;
import org.bs.web.pojo.rjf.OrderMessage;
import org.bs.web.service.rjf.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

      @Autowired
      private  OrderService  orderService;

      //查询关于订单信息
      @RequestMapping(value = "/queryOrderRJF",method = RequestMethod.GET)
      public  Boolean  queryOrderDetail(String phone,Integer paiqiId,Integer userId,Integer[] seatIds,HttpSession session){
          OrderMessage orderMessage = orderService.queryOrderDetail(phone,paiqiId,userId,seatIds);
          System.out.println(orderMessage);
          try {
              session.setAttribute("order",orderMessage);
              return  true;
          } catch (Exception e) {
              e.printStackTrace();
              return  false;
          }
      }


      @RequestMapping("/saveOrderRJF")
      public   void   saveOrder(String orderNum){
          orderService.saveOrder(orderNum);
          //System.out.println(orderNum);
      }

      @RequestMapping("/deleteOrderRJF")
      public   void  deleteOrder(String orderNum){
          orderService.deleteOrder(orderNum);
      }




}
