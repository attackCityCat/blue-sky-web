package org.bs.web.controller.hyd;

import org.bs.web.common.CommonConf;
import org.bs.web.pojo.movie.HallBean;
import org.bs.web.pojo.movie.MovieBean;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.service.hyd.MovieService;
import org.bs.web.service.hyd.MovieServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hyd")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 新增排期
     * @param paiqiBean
     * @return
     */
    @RequestMapping(value = "/movie/saveMovie")
    public Map<String,Object> saveMovie(PaiqiBean paiqiBean){
        HashMap<String, Object> map = new HashMap<>();
        Integer code = movieService.saveMovie(paiqiBean);
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
    @RequestMapping(value = "/movie/findMoviePaiqi",method = RequestMethod.GET)
    public List<PaiqiBean> findMoviePaiqi(){
        return movieService.findMoviePaiqi();
    }

    @RequestMapping("findMovieList")
    public List<MovieBean> findMovieBeanList(){
        return movieService.findMovieBeanList();
    }

    @RequestMapping("findHallList")
    public List<HallBean> findHallList(){
        return movieService.findHallList();
    }

    @RequestMapping("findPaiSeatSum")
    public Boolean findPaiSeatSum(Integer id){
        int object = (int) redisTemplate.opsForHash().get(CommonConf.PAI_SEAT_SUM, CommonConf.PAI_SEAT_SUM + id);
        if (object > 0)
            return true;
        else
            return false;
    }

}
