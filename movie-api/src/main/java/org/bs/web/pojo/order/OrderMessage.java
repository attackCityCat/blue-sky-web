package org.bs.web.pojo.order;

import org.bs.web.pojo.movie.SeatBean;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(value = "OrderMessage")
public class OrderMessage implements Serializable{

    private  String  id;

    private Integer paiQiId;

    private  String   movieName;  //电影名称

    private  String   movieImg;   //电影海报

    private  Integer  language;   //语言版本

    private  String   startDate;  //放映日期

    private  String startTime; //放映时间

    private  Double   moviePrice; //电影票价

    private  String   phone; //取票手机号

    private  String   hallName;  //放映厅名称

    private List<SeatBean> seatBeans;

    private Integer seatId;

    private  String   transaction;  //交易时间

    private  String   orderNum;  //订单号

    private  Date     endDate;   //结束时间

    private  String   cinemaName;  //影院名称

    private  Integer  userId;  //用户ID (用于生成订单)

    private  String   length;  //电影时长

    private  String   yuyan;  //语言版本

    private  Integer  account;  //票数

    private  Integer  jibie;  //会员级别

    private  Double   zk;  //折扣

    private  Double  totalPrice; //总价

    private  Double  fracturePrice;  //折价

    private String seatRow;

    private String seatCol;

    private String seatName;

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
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

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(String seatCol) {
        this.seatCol = seatCol;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Integer getPaiQiId() {
        return paiQiId;
    }

    public void setPaiQiId(Integer paiQiId) {
        this.paiQiId = paiQiId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
