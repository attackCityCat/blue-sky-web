package org.bs.web.service.llp;


import org.bs.web.pojo.OrderMessage;
import org.bs.web.pojo.UserBean;
import org.bs.web.util.LayuiPage;
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

    /**
     * 根据手机号修改用户昵称
     * @param name
     * @param phone
     * @return
     */
    @RequestMapping(value = "/updateUser")
    void updateUser(@RequestParam(value = "name")String name, @RequestParam(value = "phone") String phone);


    /**
     * 根据用户id 多条件查询订单信息
     * @param chaxun
     * @param page
     * @param limit
     * @param id
     * @param hello
     * @return
     */
    @RequestMapping(value = "/findOrderByUserId")
    LayuiPage findOrderByUserId(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit, @RequestParam(value = "id") Integer id);


}
