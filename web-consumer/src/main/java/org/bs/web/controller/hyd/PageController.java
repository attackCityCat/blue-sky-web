package org.bs.web.controller.hyd;

import org.bs.web.common.CommonConf;
import org.bs.web.pojo.HitMovies;
import org.bs.web.pojo.UserBean;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.service.hyd.MovieServiceApi;
import org.bs.web.service.llp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hyd")
public class PageController {
    @Autowired
    private MovieServiceApi movieServiceApi;

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/page/toMain")
    public String toMain() {
        return "hyd/view/main";
    }
    @RequestMapping("/page/toDetail")
    public String toDetail(Model model, HttpSession session,Integer id){

        UserBean attribute = (UserBean) session.getAttribute(session.getId());

        model.addAttribute("user",attribute);
        //查询电影详情
        HitMovies MoviesDetail = userService.findMoviesDetail(id);
        System.out.println(MoviesDetail);
        model.addAttribute("MoviesDetail",MoviesDetail);

        //查询出五条热映数据
        List<HitMovies> list = userService.findHitMovies(1,5);
        model.addAttribute("list", list);

        List<PaiqiBean> paiqiBean = movieServiceApi.findPaiQiById(id);

        for (PaiqiBean paiqi : paiqiBean){
            PaiqiBean object = (PaiqiBean) redisTemplate.opsForHash().get(CommonConf.PAI_QI_KEY, CommonConf.PAI_QI_KEY + paiqi.getId());
            paiqi.setYprice(paiqi.getPrice());
            paiqi.setPrice(object.getPrice());
        }

        System.out.println(paiqiBean);
        model.addAttribute("paiqiBean",paiqiBean);
        List<PaiqiBean> paiqiBeans = movieServiceApi.findPaiqiByIdAndByTime(id);
        System.out.println(paiqiBeans);
        model.addAttribute("paiqiBeans",paiqiBeans);
        return "hyd/Detail";
    }

    @RequestMapping("/page/toPaiqiList")
    public String toPaiqiList(){
        return "hyd/list";
    }

    @RequestMapping("findPaiqiList")
    @ResponseBody
    public Map<String,Object> findPaiqiList(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",movieServiceApi.findPaiqiList());
        return map;
    }

}
