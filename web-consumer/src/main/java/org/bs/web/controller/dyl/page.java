package org.bs.web.controller.dyl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dylpage")
public class page {

    @RequestMapping("toMain")
    public String toMian(){
        return "dyl/view/Main";
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "dyl/view/index";
    }

    @RequestMapping("toAddHall")
    public String toAddHall(){
        return "dyl/view/addHall";
    }

    @RequestMapping("toJTicket")
    public String toJTicket(){
        return "dyl/view/JTicket";
    }
}
