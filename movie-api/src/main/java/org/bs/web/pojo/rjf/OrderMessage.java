package org.bs.web.pojo.rjf;

import org.bs.web.pojo.SeatBean;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(value = "OrderMessage")
public class OrderMessage implements Serializable{

    private  String  id;

    private  String   movieName;  //电影名称

    private  String   movieImg;   //电影海报

    private  Integer  language;   //语言版本

    private  String   startDate;  //放映时间

    private  Double   moviePrice; //电影票价

    private  String   phone; //取票手机号

    private  String   hallName;  //放映厅名称

    private List<SeatBean> seatBeans;

    private  String   transaction;  //交易时间

    private  String   orderNum;  //订单号

    private  String   dindanNum;   //分单之前的订单号

    private  String   seatName;  //影院名称

    private  Integer  userId;  //用户ID (用于生成订单)

    private  String   length;  //电影时长

    private  String   yuyan;  //语言版本

    private  Integer  account;  //票数

    private  Integer  jibie;  //会员级别

    private  Double   zk;  //折扣

    private  Double  totalPrice; //总价

    private  Double  fracturePrice;  //折价

    public Double getFracturePrice() {
        return fracturePrice;
    }

    public void setFracturePrice(Double fracturePrice) {
        this.fracturePrice = fracturePrice;
    }

    public Integer getJibie() {
        return jibie;
    }

    public void setJibie(Integer jibie) {
        this.jibie = jibie;
    }

    public Double getZk() {
        return zk;
    }

    public void setZk(Double zk) {
        this.zk = zk;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(Double moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public List<SeatBean> getSeatBeans() {
        return seatBeans;
    }

    public void setSeatBeans(List<SeatBean> seatBeans) {
        this.seatBeans = seatBeans;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDindanNum() {
        return dindanNum;
    }

    public void setDindanNum(String dindanNum) {
        this.dindanNum = dindanNum;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getYuyan() {
        return yuyan;
    }

    public void setYuyan(String yuyan) {
        this.yuyan = yuyan;
    }

    public OrderMessage(String id, String movieName, String movieImg, Integer language, String startDate, Double moviePrice, String phone, String hallName, List<SeatBean> seatBeans, String transaction, String orderNum, String dindanNum, String seatName, Integer userId, String length, String yuyan, Integer account, Integer jibie, Double zk, Double totalPrice, Double fracturePrice) {
        this.id = id;
        this.movieName = movieName;
        this.movieImg = movieImg;
        this.language = language;
        this.startDate = startDate;
        this.moviePrice = moviePrice;
        this.phone = phone;
        this.hallName = hallName;
        this.seatBeans = seatBeans;
        this.transaction = transaction;
        this.orderNum = orderNum;
        this.dindanNum = dindanNum;
        this.seatName = seatName;
        this.userId = userId;
        this.length = length;
        this.yuyan = yuyan;
        this.account = account;
        this.jibie = jibie;
        this.zk = zk;
        this.totalPrice = totalPrice;
        this.fracturePrice = fracturePrice;
    }

    public OrderMessage() {
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "id='" + id + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieImg='" + movieImg + '\'' +
                ", language=" + language +
                ", startDate='" + startDate + '\'' +
                ", moviePrice=" + moviePrice +
                ", phone='" + phone + '\'' +
                ", hallName='" + hallName + '\'' +
                ", seatBeans=" + seatBeans +
                ", transaction='" + transaction + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", dindanNum='" + dindanNum + '\'' +
                ", seatName='" + seatName + '\'' +
                ", userId=" + userId +
                ", length='" + length + '\'' +
                ", yuyan='" + yuyan + '\'' +
                ", account=" + account +
                ", jibie=" + jibie +
                ", zk=" + zk +
                ", totalPrice=" + totalPrice +
                ", fracturePrice=" + fracturePrice +
                '}';
    }
}
