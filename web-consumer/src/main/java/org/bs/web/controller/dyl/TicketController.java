package org.bs.web.controller.dyl;

import org.bs.web.common.CommonConf;
import org.bs.web.pojo.CheckBean;
import org.bs.web.pojo.order.OrderMessage;
import org.bs.web.pojo.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("dyl")
public class TicketController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("JTicket")
    public HashMap<String, Object> JianTicket(String orderNum) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap<String, Object> map = new HashMap<String, Object>();

        OrderStatus orderStatus = (OrderStatus) redisTemplate.opsForHash().get(CommonConf.ORDER_STATUS, CommonConf.ORDER_STATUS + orderNum);

        if (orderStatus == null){
            map.put("msg","无此单号");
            return map;
        }

        String object = (String) redisTemplate.opsForHash().get(CommonConf.TIME, CommonConf.TIME + orderNum);

        String oneHoursAgoTime="";

        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse(object);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(startDate);
        //rightNow.add(Calendar.DATE, -1);
        rightNow.add(Calendar.HOUR, -1);
        Date startDate1=rightNow.getTime();


        if (startDate.after(date) && date.after(startDate1)){

            if (orderStatus.getStatus().equals("已付款")){
                orderStatus.setStatus("已消费");
                redisTemplate.opsForHash().put(CommonConf.ORDER_STATUS, CommonConf.ORDER_STATUS + orderNum,orderStatus);
                map.put("msg", "检票成功！");
                return map;
            }else{
                map.put("msg", "此票已消费！");
                return map;
            }

        }else if (date.after(startDate)){
            map.put("msg","已超过检票时间！");
            return map;
        }else {
            map.put("msg","未到检票时间!");
            return map;
        }



    }
}