package org.bs.web.controller.dyl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class page {

    @RequestMapping("toMain")
    public String toMian(){
        return "view/Main";
    }
}
