package org.bs.web.pojo.rjf;

import java.io.Serializable;

//订单详情
public class OrderDetailBean implements Serializable {
    private static final long serialVersionUID = 429172086553077491L;

    private   Integer   id;

    private   Integer   paiqiId;  //排期ID

    private   Integer   userId;   //用户ID

    private   String    num;  //订单号

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaiqiId() {
        return paiqiId;
    }

    public void setPaiqiId(Integer paiqiId) {
        this.paiqiId = paiqiId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public OrderDetailBean(Integer id, Integer paiqiId, Integer userId, String num) {
        this.id = id;
        this.paiqiId = paiqiId;
        this.userId = userId;
        this.num = num;
    }

    public OrderDetailBean() {
    }

    @Override
    public String toString() {
        return "OrderDetailBean{" +
                "id=" + id +
                ", paiqiId=" + paiqiId +
                ", userId=" + userId +
                ", num='" + num + '\'' +
                '}';
    }
}
