package org.bs.web.controller.dyl;

import org.bs.web.pojo.CheckBean;
import org.bs.web.service.dyl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            HashMap<String, Object> map = new HashMap<String, Object>();

            Query query = new Query();
            query.addCriteria(Criteria.where("orderNum").is(orderNum));
            CheckBean checkBean =  mongoTemplate.findOne(query, CheckBean.class);
            System.out.print(checkBean);
            if (checkBean!=null && !"".equals(checkBean)){
                if (checkBean.getStatus().equals("已付款")){
                    checkBean.setStatus("已消费");
                    mongoTemplate.save(checkBean);
                    map.put("msg", "检票成功！");
                    return map;
                }else{
                    map.put("msg", "此票已消费！");
                    return map;
                }
            }else {
                map.put("msg", "没有相关信息！");
                return map;
            }

    }
}
