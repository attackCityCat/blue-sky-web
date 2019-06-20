package org.bs.web.controller.hyd;

import org.bs.web.pojo.movie.HitMovies;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.UserBean;
import org.bs.web.service.hyd.MovieServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
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
    public String toDetail(Model model, HttpSession session,Integer id){

        UserBean attribute = (UserBean) session.getAttribute(session.getId());

        model.addAttribute("user",attribute);
        //查询电影详情
        HitMovies MoviesDetail = movieServiceApi.findMoviesDetail(id);
        System.out.println(MoviesDetail);
        model.addAttribute("MoviesDetail",MoviesDetail);

        //查询出五条热映数据
        List<HitMovies> list = movieServiceApi.findHitMovies();
        model.addAttribute("list", list);

        List<PaiqiBean> paiqiBean = movieServiceApi.findPaiQiById(id);
        System.out.println(paiqiBean);
        model.addAttribute("paiqiBean",paiqiBean);
        List<PaiqiBean> paiqiBeans = movieServiceApi.findPaiqiByIdAndByTime(id);
        System.out.println(paiqiBeans);
        model.addAttribute("paiqiBeans",paiqiBeans);
        return "hyd/view/Detail";
    }

}
