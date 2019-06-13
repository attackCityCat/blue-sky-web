package org.bs.web.service.llp;


import org.bs.web.pojo.UserBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.SunHints;

public interface UserServiceApi {
    /**
     * 用户登陆操作，根据手机号查询。
     * @param phone
     * @return
     */
    @RequestMapping(value = "/findByPhone")
    UserBean findByPhone(@RequestParam(value = "phone") String phone);

    /**
     * 新增用户信息
     * @param userBean
     */
    @RequestMapping(value = "/addUser")
    Boolean addUser(@RequestBody UserBean userBean);
}
