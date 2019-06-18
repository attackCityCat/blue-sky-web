package org.bs.web.controller.ljw;

import org.bs.web.mapper.ljw.NavMapper;
import org.bs.web.pojo.tree.NavBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Lenovo
 * @title: NavController
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1321:06
 */
@Controller
public class NavController {

    @Autowired
    private NavMapper navMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //把树存入redis
    @RequestMapping(value = "findTree")
    @ResponseBody
    public List<NavBean> findTree(){
        //定义key
        String treeKey = "treeKey";
        //判断缓存中有没有
        Boolean hasKey = redisTemplate.hasKey(treeKey);
        //如果有从缓存中获取
        if(hasKey){
            List<Object> range = redisTemplate.opsForList().range(treeKey, 0, -1);
            List<NavBean> list = (List<NavBean>) range.get(0);
            return list;
        }else{
            //没有就从数据库获取，并存入redis
            List<NavBean> treeList = findTreeList(0);
            redisTemplate.opsForList().leftPush(treeKey,treeList);
            return treeList;
        }
    }

    private List<NavBean> findTreeList(int i) {
        List<NavBean> list = navMapper.findTreeList(i);
        for (NavBean navBean : list) {
            Integer id = navBean.getId();
            List<NavBean> treeList = findTreeList(id);
            if (treeList!=null&&treeList.size()>0){
                navBean.setState(false);
            }
            navBean.setChildren(treeList);
        }
        return list;
    }
}
