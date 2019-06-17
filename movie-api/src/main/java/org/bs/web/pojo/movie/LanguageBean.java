package org.bs.web.pojo.movie;

import java.io.Serializable;

public class LanguageBean implements Serializable {

    private static final long serialVersionUID = -5937335129449355579L;
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
