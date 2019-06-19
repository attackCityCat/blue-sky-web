package org.bs.web.controller.hyd;

import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.UserBean;
import org.bs.web.service.hyd.MovieServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("hyd")
public class PageController {
    @Autowired
    private MovieServiceApi movieServiceApi;
    @RequestMapping("/page/toMain")
    public String toMain() {
        return "hyd/view/main";
    }
    @RequestMapping("/page/toDetail")
    public String toDetail(Model model, HttpSession session){
        UserBean attribute = (UserBean) session.getAttribute(session.getId());
        model.addAttribute("user",attribute);
        Integer id = 2;
        List<PaiqiBean> paiqiBean = movieServiceApi.findPaiQiById(id);
        System.out.println(paiqiBean);
        model.addAttribute("paiqiBean",paiqiBean);
        return "hyd/view/Detail";
    }
}
