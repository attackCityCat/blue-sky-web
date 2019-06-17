package org.bs.web.controller.ljw;

import org.bs.web.mapper.ljw.NavMapper;
import org.bs.web.pojo.tree.NavBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "findTree")
    @ResponseBody
    public List<NavBean> findTree(){
        return findTreeList(0);
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
