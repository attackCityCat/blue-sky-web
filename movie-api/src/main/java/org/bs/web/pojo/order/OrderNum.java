package org.bs.web.pojo.order;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OrderNum")
public class OrderNum {

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public OrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
