package org.bs.web.controller;

import org.bs.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public String test(){

        System.out.println("1231231");
        return testService.test();
    }
}
