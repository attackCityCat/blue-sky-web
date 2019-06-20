package org.bs.web.controller.ljw;

import org.bs.web.mapper.ljw.LoginMapperLjw;
import org.bs.web.pojo.login.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author Lenovo
 * @title: LoginControllerLjw
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/2010:44
 */
@Controller
public class LoginControllerLjw {

    @Autowired
    private LoginMapperLjw loginMapperLjw;

    @RequestMapping(value = "loginLjw")
    @ResponseBody
    public HashMap<String,Object> loginLjw(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password){
        HashMap<String, Object> map = new HashMap<String,Object>();
        LoginBean loginBean = loginMapperLjw.queryUserByAccount(account);
        if (loginBean==null){
            map.put("code",1);
            map.put("flag","账号不存在!");
            return map;
        }
        if (!loginBean.getPassword().equals(password)){
            map.put("code",2);
            map.put("flag","密码错误!");
            return map;
        }
        map.put("code",0);
        map.put("flag","登陆成功");
        return map;
    }
}
