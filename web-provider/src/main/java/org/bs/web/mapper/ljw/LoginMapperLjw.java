package org.bs.web.mapper.ljw;

import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.login.LoginBean;

/**
 * @author Lenovo
 * @title: LoginMapperLjw
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/2010:44
 */
public interface LoginMapperLjw {

    @Select("select * from t_login where account = #{value}")
    LoginBean queryUserByAccount(String account);
}
