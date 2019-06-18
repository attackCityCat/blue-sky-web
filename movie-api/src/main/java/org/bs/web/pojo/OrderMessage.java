package org.bs.web.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "OrderMessage")
public class OrderMessage implements Serializable{

    private  String  id;

    private  String   movieName;  //电影名称

    private  String   movieImg;   //电影海报

    private  Integer  language;   //语言版本

    private  Date     startDate;  //放映时间

    private  Double   moviePrice; //电影票价

    private  String   phone; //取票手机号

    private  String   hallName;  //放映厅名称

    private  String   seatRow;  //座位行号

    private  String   seatClumn;  //座位列号

    private  String   transaction;  //交易时间

    private  String   orderNum;  //订单号

    private  Date     endDate;   //结束时间

    private  String   cinemaName;  //影院名称

    private  Integer  userId;  //用户ID (用于生成订单)

    private  String   length;  //电影时长

    private  String   yuyan;  //语言版本

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
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

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatClumn() {
        return seatClumn;
    }

    public void setSeatClumn(String seatClumn) {
        this.seatClumn = seatClumn;
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

    public OrderMessage(String id, String movieName, String movieImg, Integer language, Date startDate, Double moviePrice, String phone, String hallName, String seatRow, String seatClumn, String transaction, String orderNum, Date endDate, String cinemaName, Integer userId, String length, String yuyan) {
        this.id = id;
        this.movieName = movieName;
        this.movieImg = movieImg;
        this.language = language;
        this.startDate = startDate;
        this.moviePrice = moviePrice;
        this.phone = phone;
        this.hallName = hallName;
        this.seatRow = seatRow;
        this.seatClumn = seatClumn;
        this.transaction = transaction;
        this.orderNum = orderNum;
        this.endDate = endDate;
        this.cinemaName = cinemaName;
        this.userId = userId;
        this.length = length;
        this.yuyan = yuyan;
    }

    public OrderMessage() {
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", movieImg='" + movieImg + '\'' +
                ", language=" + language +
                ", startDate=" + startDate +
                ", moviePrice=" + moviePrice +
                ", phone='" + phone + '\'' +
                ", hallName='" + hallName + '\'' +
                ", seatRow='" + seatRow + '\'' +
                ", seatClumn='" + seatClumn + '\'' +
                ", transaction='" + transaction + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", endDate=" + endDate +
                ", cinemaName='" + cinemaName + '\'' +
                ", userId=" + userId +
                ", length='" + length + '\'' +
                ", yuyan='" + yuyan + '\'' +
                '}';
    }
}
