package org.bs.web.controller.llp;

import org.bs.web.mapper.UserMapper;
import org.bs.web.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

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
