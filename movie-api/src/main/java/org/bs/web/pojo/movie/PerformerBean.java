package org.bs.web.pojo.movie;

import java.io.Serializable;

/**
 * @author Lenovo
 * @title: PerformerBean
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1710:58
 */
public class PerformerBean implements Serializable {

    private static final long serialVersionUID = 3200575329051066422L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
