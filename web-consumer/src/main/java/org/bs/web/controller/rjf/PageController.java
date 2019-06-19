package org.bs.web.controller.rjf;

import org.bs.web.pojo.rjf.OrderMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("/toOrder")
    public   String  toMain(HttpSession session, Model model){
        OrderMessage order = (OrderMessage) session.getAttribute("order");
        model.addAttribute("orders",order);
        return "jsp/order";
    }

    @RequestMapping("/toPayMent")
    public   String  toPayMent(HttpSession session, Model model){
        OrderMessage order = (OrderMessage) session.getAttribute("order");
        model.addAttribute("orders",order);
        return  "jsp/payment";
    }

    @RequestMapping("/toIndex")
    public   String  toIndex(){
        return  "index";
    }

    @RequestMapping("/toSuccess")
    public   String  toSuccess(HttpSession session, Model model){
        OrderMessage order = (OrderMessage) session.getAttribute("order");
        model.addAttribute("orders",order);
        return  "jsp/success";
    }
}
