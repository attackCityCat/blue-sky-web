package org.bs.web.mapper.ljw;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bs.web.pojo.tree.NavBean;

import java.util.List;

/**
 * @author Lenovo
 * @title: NavMapper
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1321:07
 */
@Mapper
public interface NavMapper {

    @Select("select * from t_tree where pid = #{value}")
    List<NavBean> findTreeList(int i);
}
