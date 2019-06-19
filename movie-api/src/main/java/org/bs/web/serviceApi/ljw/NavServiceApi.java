package org.bs.web.serviceApi.ljw;

import org.bs.web.pojo.tree.NavBean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Lenovo
 * @title: NavServiceApi
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1321:03
 */
public interface NavServiceApi {
    @RequestMapping(value = "findTree")
    List<NavBean> findTree();
}
