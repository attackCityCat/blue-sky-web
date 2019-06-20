package org.bs.web.controller.ljw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lenovo
 * @title: PageController
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1320:39
 */
@Controller
@RequestMapping(value = "page")
public class PageControllerLjw {

    @RequestMapping(value = "/toList")
    public String toList(){
        return "ljw/list";
    }

    @RequestMapping(value = "/toMain")
    public String toMain(){
        return "ljw/main";
    }
}
