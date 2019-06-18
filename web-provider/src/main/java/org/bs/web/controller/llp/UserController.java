package org.bs.web.controller.llp;

import org.bs.web.mapper.UserMapper;
import org.bs.web.pojo.OrderMessage;
import org.bs.web.pojo.UserBean;
import org.bs.web.util.LayuiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据用户的id多条件查询对应的订单号
     * @param page
     * @param limit
     * @param id
     * @param chaxun
     * @return
     */
    @RequestMapping(value = "/findOrderByUserId")
    @ResponseBody
    public LayuiPage findOrderByUserId(@RequestParam(value = "page")Integer page, @RequestParam(value = "limit")Integer limit, @RequestParam(value = "id")Integer id){

        LayuiPage LayuiPage = new LayuiPage();
        Query query = new Query();
            query.addCriteria(Criteria.where("userId").is(id));
        // 查询总条数
        Integer count = (int) mongoTemplate.count(query, OrderMessage.class);
        //总条数
        LayuiPage.setCount(count);
        //分页查询
        query.skip((page - 1) * limit);

        query.limit(limit);

        List<OrderMessage> list = mongoTemplate.find(query, OrderMessage.class);
        //查询的结果
        LayuiPage.setData(list);

        return LayuiPage;
    }

    /**
     * 根据手机号修改用户昵称
     * @param name
     * @param phone
     * @return
     */
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public void updateUser(@RequestParam(value = "name")String name, @RequestParam(value = "phone") String phone){
        userMapper.updateUser(name,phone);
    }

    /**
     * 用户登陆操作，根据手机号查询。
     * @param phone
     * @return
     */
    @RequestMapping(value = "/findByPhone")
    public UserBean findByPhone(@RequestParam(value = "phone") String phone){
        return userMapper.findByPhone(phone);
    }

    /**
     * 新增用户信息
     * @param userBean
     */
    @RequestMapping(value = "/addUser")
    public Boolean addUser(@RequestBody UserBean userBean){
        try {
            userMapper.addUser(userBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
