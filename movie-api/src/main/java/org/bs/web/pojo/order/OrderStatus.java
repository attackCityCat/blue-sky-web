package org.bs.web.pojo.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(value = "OrderStatus")
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 536662325622805042L;
    @Id
    private String orderNum;

    private String status = "已付款";

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
