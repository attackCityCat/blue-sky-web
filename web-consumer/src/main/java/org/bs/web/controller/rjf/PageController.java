package org.bs.web.controller.rjf;

import org.bs.web.pojo.SeatBean;
import org.bs.web.pojo.rjf.OrderMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("/toOrder")
    public   String  toMain(HttpSession session, Model model){
        OrderMessage order = (OrderMessage) session.getAttribute("order");
        List<SeatBean> seatBeans = order.getSeatBeans();
        String  seat = "";
        for (SeatBean seatBean : seatBeans){
            String seatRow = seatBean.getSeatRow();
            String seatColumn = seatBean.getSeatColumn();
            seat += "<li>"+seatRow+"排"+seatColumn+"列"+"</li>";
        }
        order.setSeatName(seat);
        model.addAttribute("orders",order);
        return "jsp/order";
    }

    @RequestMapping("/toPayMent")
    public   String  toPayMent(HttpSession session, Model model){
        OrderMessage order = (OrderMessage) session.getAttribute("order");
        List<SeatBean> seatBeans = order.getSeatBeans();
        String  seat = "";
        for (SeatBean seatBean : seatBeans){
            String seatRow = seatBean.getSeatRow();
            String seatColumn = seatBean.getSeatColumn();
            seat += seatRow+"排"+seatColumn+"列"+"  ";
        }
        order.setSeatName(seat);
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
        List<SeatBean> seatBeans = order.getSeatBeans();
        String  seat = "";
        for (SeatBean seatBean : seatBeans){
            String seatRow = seatBean.getSeatRow();
            String seatColumn = seatBean.getSeatColumn();
            seat += seatRow+"排"+seatColumn+"列"+",";
        }
        order.setSeatName(seat);
        model.addAttribute("orders",order);
        return  "jsp/success";
    }
}
