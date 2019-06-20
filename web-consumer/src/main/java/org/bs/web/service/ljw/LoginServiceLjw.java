package org.bs.web.service.ljw;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @author Lenovo
 * @title: LoginServiceLjw
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/2010:39
 */
@FeignClient(value = "web-provider")
public interface LoginServiceLjw {

    @RequestMapping(value = "loginLjw")
    HashMap<String, Object> loginLjw(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password);


}
