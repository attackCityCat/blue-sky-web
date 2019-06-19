package org.bs.web.pojo.rjf;

import java.io.Serializable;

//订单座位
public class OrderSeatBean implements Serializable {
    private static final long serialVersionUID = -2180977502806875316L;

    private   Integer   id;

    private   Integer   orderDetailId; //订单详情ID

    private   Integer   seatId;  //座位ID

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public OrderSeatBean(Integer id, Integer orderDetailId, Integer seatId) {
        this.id = id;
        this.orderDetailId = orderDetailId;
        this.seatId = seatId;
    }

    public OrderSeatBean() {
    }

    @Override
    public String toString() {
        return "OrderSeatBean{" +
                "id=" + id +
                ", orderDetailId=" + orderDetailId +
                ", seatId=" + seatId +
                '}';
    }
}
