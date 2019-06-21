package org.bs.web.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "checkOrder")
public class CheckBean implements Serializable {

    private static final long serialVersionUID = 4402316091681281646L;

    private  String  orderNum;

    private  String  phone;

    private  String  status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CheckBean(String orderNum, String phone, String status) {
        this.orderNum = orderNum;
        this.phone = phone;
        this.status = status;
    }

    public CheckBean() {
    }

    @Override
    public String toString() {
        return "CheckBean{" +
                "orderNum='" + orderNum + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}