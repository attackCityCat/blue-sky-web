package org.bs.web.controller.ljw.login;

import org.bs.web.service.ljw.LoginServiceLjw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author Lenovo
 * @title: LoginControllerLjw
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/2010:29
 */
@Controller
public class LoginControllerLjw {

    @Autowired
    private LoginServiceLjw loginServiceLjw;

    @RequestMapping(value = "/loginLjw")
    @ResponseBody
    public HashMap<String,Object> loginLjw(String account, String password){
        return loginServiceLjw.loginLjw(account,password);
    }

}
