package org.bs.web.dyl.pojo;

import java.util.Date;

public class MovieAboutBean {

    private Integer id ;

    private String name;

    private String img;

    private Integer status;

    private String director;

    private Integer length;

    private Integer language;

    private Double price;

    private  String detail;

    private Date firstTime;

    private Integer performeId;

    private String performerName;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Integer getPerformeId() {
        return performeId;
    }

    public void setPerformeId(Integer performeId) {
        this.performeId = performeId;
    }

    public String getPerformeName() {
        return performerName;
    }

    public void setPerformeName(String performeName) {
        this.performerName = performeName;
    }

    @Override
    public String toString() {
        return "MovieAboutBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", status=" + status +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", language=" + language +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", firstTime=" + firstTime +
                ", performeId=" + performeId +
                ", performerName='" + performerName + '\'' +
                '}';
    }
}
