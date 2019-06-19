package org.bs.web.mapper.llp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bs.web.pojo.UserBean;

@Mapper
public interface UserMapper {

    /**
     * 用户登陆操作，根据手机号查询。
     * @param phone
     * @return
     */
    @Select(" SELECT * FROM t_user WHERE phoneNumber = #{value}  ")
    UserBean findByPhone(String phone);

    @Insert(" INSERT INTO t_user(phoneNumber,password,name) VALUES(#{phoneNumber},#{password},#{name}) ")
    void addUser(UserBean userBean);

    @Update(" UPDATE t_user  SET NAME = #{name} WHERE phoneNumber = #{phone} ")
    void updateUser(String name, String phone);
}
