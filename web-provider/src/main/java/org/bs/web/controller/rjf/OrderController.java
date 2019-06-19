package org.bs.web.controller.rjf;

import org.bs.web.common.CommonConf;
import org.bs.web.config.RabbitConfig;
import org.bs.web.mapper.rjf.OrderMapper;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.SeatBean;
import org.bs.web.pojo.order.OrderMessage;
import org.bs.web.pojo.order.OrderNum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class OrderController {

       @Autowired
       private OrderMapper orderMapper;

       @Autowired
       private  MongoTemplate  mongoTemplate;

       @Resource
       private RedisTemplate<String, Object> redisTemplate;

       @Resource
       private RedisTemplate<String, String> redisTemplate2;

       /*@Autowired
       private  AmqpTemplate  amqpTemplate;*/

       @Autowired
       private   RabbitTemplate   rabbitTemplate;


       private static Integer num = 0;

        //生成订单号
        private  String  getOrderNum(String movie, String phone, Integer userId){

            String  key = "";
            //电影名  取hashcode % 7
            //String  movie = "怪兽之王";
            int code = movie.hashCode()%7;
            //System.out.println("电影名:  "+code);

            //用户Id 取hashcode % 9
            //int  userId = 5;
            String s1 = String.valueOf(userId);
            int hashCode = s1.hashCode()%9;
            //System.out.println("用户id：  "+hashCode);

            //用户电话号 最后一位
            //String  phone = "15003504163";
            String p = phone.substring(phone.length() - 1);
            //System.out.println(p);

            //年月日时分 (时间戳)
            Timestamp timestamp = new Timestamp(new Date().getTime());//获取当前时间
            //System.out.println(date.getClass().getName());  //打印date数据类型
            //System.out.println(timestamp);           //打印当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
            String format = sdf.format(timestamp);   //将Date类型转换成String类型
            //System.out.println(format.getClass().getName());  //打印format数据类型
            //System.out.println(format);

            //从00000自增到99999
            String nu = num + "";
            String temp = "";
            if (num == 0){
                nu = "00000";
            }else{
                for (int i = 0;i < 5 - nu.length();i++){
                    temp += "0";
                }
                nu = temp + nu;
            }

            String  orderNum = key+code+hashCode+p+format+nu;
            //System.out.println("订单号:  "+dindan);
            num++;

            //判断订单号是否重复
            Query q = new Query();
            q.addCriteria(Criteria.where("orderNum").is(orderNum));

            OrderMessage one = mongoTemplate.findOne(q, OrderMessage.class);

            //如果存在则回调，重新生成订单号再判断，直到订单号不重复为止
            if (one != null){
                orderNum = getOrderNum(movie, phone, userId);
            }

            //将订单信息存入mongodb
            mongoTemplate.save(new OrderNum(orderNum));


            //返回订单号
            return  orderNum;
        }


        //生成订单信息
        @RequestMapping(value = "/queryOrderRJF")
        public   OrderMessage queryOrderDetail(@RequestParam("phone") String phone,@RequestParam("paiqiId") Integer paiqiId,@RequestParam("userId") Integer userId,@RequestParam("seatIds") Integer[] seatIds){
            //从redis中获取排期表数据
            PaiqiBean paiqi = (PaiqiBean) redisTemplate.opsForHash().get(CommonConf.PAI_QI_KEY, CommonConf.PAI_QI_KEY + paiqiId);
            Integer hallId = paiqi.getHallId(); //放映厅ID
            Integer movieId = paiqi.getMovieId(); //电影ID
            double price = paiqi.getPrice();
            System.out.println(price);

            //生成订单详情
            OrderMessage orderMessage = orderMapper.queryOrderDetail(paiqiId);

            String movieName = orderMessage.getMovieName(); //电影名称


            ArrayList<SeatBean> seatBeans = new ArrayList<>();
            for (Integer seatId : seatIds){
                Boolean hasKey = redisTemplate.opsForHash().hasKey(CommonConf.HALL_SEATS_KEY + hallId, CommonConf.SEATS_INFO_KEY + seatId);
                if (hasKey) {
                    SeatBean seatBean = (SeatBean) redisTemplate.opsForHash().get(CommonConf.HALL_SEATS_KEY + hallId, CommonConf.SEATS_INFO_KEY + seatId);
                    seatBeans.add(seatBean);

                }else {
                    SeatBean seatBean = orderMapper.findSeatInfoById(seatId);
                    seatBeans.add(seatBean);
                }

            }

            orderMessage.setPaiQiId(paiqiId);

            orderMessage.setSeatBeans(seatBeans);

            orderMessage.setPhone(phone);
            orderMessage.setUserId(userId);

            orderMessage.setAccount(seatBeans.size());
            orderMessage.setTotalPrice(seatBeans.size()*price);

            //打折
            Double totalPrice = orderMessage.getTotalPrice();
            Double zk = orderMessage.getZk()/10;
            //System.out.println(zk);
            Integer level = orderMessage.getJibie();
            if(level > 0){
                orderMessage.setFracturePrice(totalPrice*zk);
            }else{
                orderMessage.setFracturePrice(totalPrice);
            }

            //生成订单时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            orderMessage.setTransaction(format);
            Integer language = orderMessage.getLanguage();

            //生成订单号
            String orderNum = getOrderNum(movieName, phone, userId);

            orderMessage.setOrderNum(orderNum); //订单号

            System.out.println(orderMessage);

            //并且存入缓存
            redisTemplate.opsForHash().put(CommonConf.ORDER_KEY,orderMessage.getOrderNum(),orderMessage);
            Integer paiQiId = orderMessage.getPaiQiId();
            for (Integer seatId : seatIds){
                redisTemplate2.opsForValue().set(paiQiId+"-"+seatId,"yes",CommonConf.PAI_QI_SEAT_CACHE_TIME, TimeUnit.MINUTES);
            }

            return  orderMessage;
        }

        //支付成功后,进行分单
        @RequestMapping("/saveOrderRJF")
        public   void   saveOrder(@RequestParam("orderNum") String orderNum){

            OrderMessage order = (OrderMessage) redisTemplate.opsForHash().get(CommonConf.ORDER_KEY, orderNum);
            /*System.out.println(order);
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,order);*/

            List<SeatBean> seatBeans = order.getSeatBeans();
            for (SeatBean seatBean : seatBeans){
                ArrayList<SeatBean> list = new ArrayList<>();
                list.add(seatBean);
                order.setSeatBeans(list);
                order.setTotalPrice(order.getFracturePrice());
                String num = getOrderNum(order.getMovieName(), order.getPhone(), order.getUserId());
                order.setOrderNum(num);

                order.setSeatRow(seatBean.getSeatRow());
                order.setSeatCol(seatBean.getSeatCol());
                order.setSeatId(seatBean.getId());
                rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,order);
                redisTemplate2.delete(order.getPaiQiId()+"-"+seatBean.getId());
            }

            redisTemplate.opsForHash().delete(CommonConf.ORDER_KEY,orderNum);


        }


        @RequestMapping("/deleteOrderRJF")
        public   void   deleteOrder(@RequestParam("orderNum") String orderNum){
            redisTemplate.opsForHash().delete(CommonConf.ORDER_KEY,orderNum);
        }


}
