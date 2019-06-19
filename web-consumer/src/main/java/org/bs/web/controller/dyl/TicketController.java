package org.bs.web.controller.dyl;

import org.bs.web.pojo.CheckBean;
import org.bs.web.service.dyl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("dyl")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("JTicket")
    public HashMap<String, Object> JianTicket(String orderNum){
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HashMap<String, Object> map = new HashMap<String, Object>();

            Query query = new Query();
            Query query1 = new Query();
            query.addCriteria(Criteria.where("orderNum").is(orderNum));
            CheckBean checkBean =  mongoTemplate.findOne(query, CheckBean.class);
            String code = checkBean.getOrderNum();
            query1.addCriteria(Criteria.where("orderNum").is(code));
            OrderMessage orderMessage = mongoTemplate.findOne(query1,OrderMessage.class);
            System.out.print(checkBean);
            if (checkBean!=null && !"".equals(checkBean)){

                String oneHoursAgoTime="";

                Date startDate = (Date) orderMessage.getStartDatenew;

                Date date = new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar rightNow = Calendar.getInstance();
                rightNow.setTime(startDate);
                //rightNow.add(Calendar.DATE, -1);
                rightNow.add(Calendar.HOUR, -1);
                Date startDate1=rightNow.getTime();


                if (startDate.after(date) && date.after(startDate1)){

                    if (checkBean.getStatus().equals("已付款")){
                        checkBean.setStatus("已消费");
                        mongoTemplate.save(checkBean);
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

            }else {
                //String oneHoursAgoTime="";
                //Date dt = new Date();
                //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //Calendar rightNow = Calendar.getInstance();
                //rightNow.setTime(dt);
                //rightNow.add(Calendar.DATE, -1); 减少一天
                //rightNow.add(Calendar.HOUR, -1); 减少一小时
                //Date dt1=rightNow.getTime();
                //String dtd = sdf.format(dt);
                //String dtd1 = sdf.format(dt1);
                //oneHoursAgoTime = sdf.format(dt1);
                //System.out.print(dtd);
                //System.out.print(dtd1);

                    map.put("msg", "没有相关信息！");
                    return map;

            }

    }
}
