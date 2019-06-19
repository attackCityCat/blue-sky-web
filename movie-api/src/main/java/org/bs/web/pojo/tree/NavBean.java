package org.bs.web.pojo.tree;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lenovo
 * @title: NavBean
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1320:50
 */
public class NavBean implements Serializable {
    private static final long serialVersionUID = -4294053404428715705L;

    private Integer id;

    private String text;

    private String url;

    private Integer pid;

    private List<NavBean> children;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<NavBean> getChildren() {
        return children;
    }

    public void setChildren(List<NavBean> children) {
        this.children = children;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}