package org.bs.web.controller.hyd;

import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.service.hyd.MovieServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hyd")
public class MovieController {
    @Autowired
    private MovieServiceApi movieServiceApi;

    /**
     * 新增排期
     * @param paiqiBean
     * @return
     */
    @RequestMapping(value = "/movie/saveMovie")
    public Map<String,Object> saveMovie(PaiqiBean paiqiBean){
        HashMap<String, Object> map = new HashMap<>();
        Integer code = movieServiceApi.saveMovie(paiqiBean);
        map.put("code",code);
        if (code == 1)
            map.put("msg","不符合营业时间");
        if (code == 2)
            map.put("msg","不符合电影档期");
        if (code == 3)
            map.put("msg","排期冲突");
        if (code == 4)
            map.put("msg","系统故障");
        if (code == 0)
            map.put("msg","新增成功");
        return map;
    }

    /**
     * 查询排期
     * @return
     */
    @RequestMapping(value = "/movie/findMoviePaiqi")
    public List<PaiqiBean> findMoviePaiqi(){
        //String movieDate = "2019-06-22";
        Integer movieId = 2;
        List<PaiqiBean> moviePaiqi = movieServiceApi.findMoviePaiqi(movieId);

        return moviePaiqi;
    }

}
