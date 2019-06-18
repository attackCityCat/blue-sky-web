package org.bs.web.controller.xinx;

import org.bs.web.common.CommonConf;
import org.bs.web.pojo.movie.PaiqiBean;
import org.bs.web.pojo.movie.SeatBean;
import org.bs.web.service.xinx.XinxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("xinx")
public class XinxController {


    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private XinxService xinxService;

    /**
     *
     * @param id        排期Id
     * @return
     */
    @RequestMapping("/page/toSeat")
    public String toSeat(Integer id,Model model){
        model.addAttribute("id",id);
        return "xinx/seat/seat";
    }

    @RequestMapping("init")
    @ResponseBody
    public Map<String,Object> init(Integer id){

        HashMap<String, Object> result = new HashMap<>();

        PaiqiBean paiqiBean = null;
        Boolean hasKey = redisTemplate.opsForHash().hasKey(CommonConf.PAI_QI_KEY, CommonConf.PAI_QI_KEY + id);
        if (hasKey) {
            paiqiBean = (PaiqiBean) redisTemplate.opsForHash().get(CommonConf.PAI_QI_KEY, CommonConf.PAI_QI_KEY + id);
        } else {
            paiqiBean = xinxService.findPaiqiInfoById(id);
        }


        String primaryKey = CommonConf.HALL_SEATS_KEY + paiqiBean.getHallId();
        Boolean hasPrimaryKey = redisTemplate.hasKey(primaryKey);

        List<SeatBean> seatBeans = null;
        if (hasPrimaryKey) {
            //List<ProductBean> list = (List) map.values().stream().collect(Collectors.toList());
            seatBeans = (List)redisTemplate.opsForHash().entries(primaryKey).values().stream().collect(Collectors.toList());
        }else {
            seatBeans = xinxService.findSeatListByHallId(paiqiBean.getHallId());
            for (SeatBean seatBean : seatBeans){
                //生成 副键 生成规则 ： 常量字符串+座位ID
                String repliKey = CommonConf.SEATS_INFO_KEY + seatBean.getId();
                redisTemplate.opsForHash().put(primaryKey,repliKey,seatBean);
            }
        }

        result.put("seatBeans",seatBeans);

        Integer hallType = xinxService.findHallType(paiqiBean.getHallId());

        result.put("hallType",hallType);

        return result;
    }
}
