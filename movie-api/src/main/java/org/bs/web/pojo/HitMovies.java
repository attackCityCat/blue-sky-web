package org.bs.web.pojo;

import java.io.Serializable;

public class HitMovies implements Serializable {
    private static final long serialVersionUID = -6103281802384770731L;
    private Integer id;

    private String name;    //电影名

    private String img;     //图

    private String tagName;     //标签

    private String typeName;  //类型 2D 3D等

    private Integer price;      //价格

    private Integer length;     //时长

    private String director;     ///导演

    private String perName;     //演员

    private String detail;      //简介

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "HitMovies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", tagName='" + tagName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", price=" + price +
                ", length=" + length +
                ", director='" + director + '\'' +
                ", perName='" + perName + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
