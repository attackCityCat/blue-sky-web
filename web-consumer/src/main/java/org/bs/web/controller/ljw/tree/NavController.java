package org.bs.web.controller.ljw.tree;

import org.bs.web.pojo.tree.NavBean;
import org.bs.web.service.ljw.NavServiceLjw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Lenovo
 * @title: NavController
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1320:48
 */
@Controller
@RequestMapping(value = "/nav")
public class NavController {

    @Autowired
    private NavServiceLjw navService;

    @RequestMapping(value = "/findTree")
    @ResponseBody
    public List<NavBean> findTree(){
        return navService.findTree();
    }
}
