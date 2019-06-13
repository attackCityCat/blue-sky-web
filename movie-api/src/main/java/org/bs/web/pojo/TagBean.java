package org.bs.web.pojo;
import java.io.Serializable;

public class TagBean implements Serializable {

    private static final long serialVersionUID = 1052792229026318307L;
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