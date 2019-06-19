package org.bs.web.controller.rjf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bs.web.common.CommonConf;
import org.bs.web.config.HttpClientUtil;
import org.bs.web.config.Md5Util;
import org.bs.web.config.RabbitConfig;
import org.bs.web.pojo.order.OrderMessage;
import org.bs.web.pojo.order.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class OrderRabbit {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RabbitHandler
    public   void   getOrder(OrderMessage orderMessage) {

        OrderMessage message = mongoTemplate.save(orderMessage);

        String account = message.getPhone();

        HashMap<String, Object> result = new HashMap<String , Object>();
        if (message != null) {
            try {

                HashMap<String, Object> params = new HashMap<>();

                params.put("accountSid", CommonConf.SMS_ACCOUNTSID);

                params.put("to", account);

                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                System.out.println(timestamp);
                params.put("timestamp", timestamp);

                String sig = Md5Util.getMd532(CommonConf.SMS_ACCOUNTSID + CommonConf.SMS_AUTH_TOKEN + timestamp);
                params.put("sig", sig);

                String param = orderMessage.getMovieName()+","+
                        orderMessage.getStartTime()+","+orderMessage.getHallName()+","+orderMessage.getSeatRow()+
                        ","+orderMessage.getSeatCol()+","+orderMessage.getOrderNum();
                System.out.println(param);
                params.put("templateid", CommonConf.SMS_TEMPLATEID);

                params.put("param",param);

                String post = HttpClientUtil.post(CommonConf.SMS_URL, params);
                JSONObject parseObject = JSON.parseObject(post);

                String resCode = parseObject.getString("respCode");
                System.out.println("========"+resCode);

                if (parseObject.getString("respCode").equals(CommonConf.SMS_RESPCODE)) {
                    // 调用redis将验证码缓存起来
                    OrderStatus orderStatus = new OrderStatus();

                    orderStatus.setOrderNum(orderMessage.getOrderNum());

                    mongoTemplate.save(orderStatus);

                    redisTemplate.opsForHash().put(CommonConf.ORDER_NUM_KEK,CommonConf.ORDER_NUM_KEK_P+orderMessage.getPaiQiId()+CommonConf.ORDER_NUM_KEK_S+orderMessage.getSeatId(),orderMessage.getOrderNum());

                    result.put("code", 0);
                    System.out.println("发送成功");
                    result.put("msg", "发送成功");
                } else {
                    result.put("code", 1);
                    System.out.println("发送失败");
                    result.put("msg", "发送失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("发送失败2");
                result.put("code", 2);
                result.put("msg", "发送失败");
            }
        }
    }



}
