package org.bs.web.controller.rjf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bs.web.common.CommonConf;
import org.bs.web.config.HttpClientUtil;
import org.bs.web.config.Md5Util;
import org.bs.web.config.RabbitConfig;
import org.bs.web.pojo.CheckBean;
import org.bs.web.pojo.SeatBean;
import org.bs.web.pojo.rjf.OrderMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

        CheckBean checkBean = new CheckBean();

        System.out.println(orderMessage);

        OrderMessage message = mongoTemplate.save(orderMessage);

        String account = message.getPhone();

        HashMap<String, Object> result = new HashMap<String , Object>();
        if (message != null) {
            try {

                /*Integer code = (int) ((Math.random() * 9 + 1) * 100000);*/
                String code = message.getDindanNum();//订单号作为验证码

                System.out.println(code);
                HashMap<String, Object> params = new HashMap<>();

                params.put("accountSid", CommonConf.SMS_ACCOUNTSID);

                params.put("to", account);

                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                System.out.println(timestamp);
                params.put("timestamp", timestamp);

                String sig = Md5Util.getMd532(CommonConf.SMS_ACCOUNTSID + CommonConf.SMS_AUTH_TOKEN + timestamp);
                params.put("sig", sig);

                params.put("templateid", CommonConf.SMS_TEMPLATEID);

                params.put("param", code);

                String post = HttpClientUtil.post(CommonConf.SMS_URL, params);
                JSONObject parseObject = JSON.parseObject(post);

                String resCode = parseObject.getString("respCode");
                System.out.println(resCode);

                if (parseObject.getString("respCode").equals(CommonConf.SMS_RESPCODE)) {
                    // 调用redis将验证码缓存起来
                    String cacheKey = CommonConf.SMS_CODE_CACHE_KEY + account;

                    redisTemplate.opsForValue().set(cacheKey, String.valueOf(code), CommonConf.SMS_CODE_TIME_OUT, TimeUnit.MINUTES);

                    checkBean.setOrderNum(code);
                    checkBean.setPhone(account);
                    checkBean.setStatus("已付款");
                    mongoTemplate.save(checkBean);

                    result.put("code", 0);
                    result.put("msg", "发送成功");
                } else {
                    result.put("code", 1);
                    result.put("msg", "发送失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.put("code", 2);
                result.put("msg", "发送失败");
            }
        }
    }
}
