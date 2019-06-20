package org.bs.web.pojo.movie;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;


@Document(indexName = "movie",type = "movie",shards = 5,replicas = 1)
public class MovieBean implements Serializable {

    private static final long serialVersionUID = 6149653222356773426L;

    @Id
    private Integer id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String name;
    @Field(type = FieldType.Text)
    private String img;
    @Field(type = FieldType.Integer)
    private Integer status;
    @Field(type = FieldType.Integer)
    private Integer slideShow;

    @Field(type = FieldType.Text)
    private String derector;

    @Field(type = FieldType.Integer)
    private Integer length;

    @Field(type = FieldType.Text)
    private String firstTime;

    @Field(type = FieldType.Integer)
    private Integer language;

    @Field(type = FieldType.Text)
    private String languageName;

    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String detail;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Integer)
    private Integer type;

    @Field(type = FieldType.Text)
    private String typeName;

    @Field(type = FieldType.Text)
    private String startDate;

    @Field(type = FieldType.Text)
    private String endDate;

    @Field(type = FieldType.Text)
    private String tag;

    @Field(type = FieldType.Text)
    private String performer;

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

    public String getDerector() {
        return derector;
    }

    public void setDerector(String derector) {
        this.derector = derector;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(Integer slideShow) {
        this.slideShow = slideShow;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
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

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
}