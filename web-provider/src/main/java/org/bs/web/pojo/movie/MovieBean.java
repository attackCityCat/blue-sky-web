package org.bs.web.pojo.movie;

import java.io.Serializable;
import java.util.Date;


public class MovieBean implements Serializable {

    private static final long serialVersionUID = 6149653222356773426L;

    private Integer id;
    private String name;
    private String img;
    private Integer status;

    private String director;

    private Integer length;

    private String firstTime;

    private String detail;

    private Double price;

    private Integer type;
    private String typeName;

    private Integer language;
    private String languageName;

    private String startDate;

    private String endDate;

    private String tag;

    private String performer;

    @Override
    public String toString() {
        return "MovieBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", status=" + status +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", firstTime='" + firstTime + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", language=" + language +
                ", languageName='" + languageName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", tag='" + tag + '\'' +
                ", performer='" + performer + '\'' +
                '}';
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
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

    public String getFirstTime() {
        return firstTime;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
