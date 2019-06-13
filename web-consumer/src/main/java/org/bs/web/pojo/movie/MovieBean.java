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

    @Field(type = FieldType.Text)
    private String derector;

    @Field(type = FieldType.Integer)
    private Integer length;

    @Field(type = FieldType.Date)
    private Date firstTime;

    @Field(type = FieldType.Integer)
    private Integer language;

    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String detail;

    @Field(type = FieldType.Double)
    private Double price;

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

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
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
}
