package org.bs.web.pojo.movie;

import java.io.Serializable;

/**
 * @author Lenovo
 * @title: MovieTypeBean
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1416:56
 */
public class MovieTypeBean implements Serializable {

    private static final long serialVersionUID = 2228338190697034279L;

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
