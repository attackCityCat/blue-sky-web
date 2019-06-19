package org.bs.web.pojo.rjf;

import java.io.Serializable;
import java.util.Date;

//订单
public class OrderBean implements Serializable {
    private static final long serialVersionUID = -8097694913535443821L;

    private  Integer  id;  //主键

    private  Date  createTime;  //订单时间

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public OrderBean(Integer id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    public OrderBean() {
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
