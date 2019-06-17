package org.bs.web.pojo.movie;

import java.io.Serializable;

public class PaiQiSeatBean implements Serializable {

    private static final long serialVersionUID = -4300075951455942074L;
    private Integer paiQiId;    //信息所属排期ID
    private Integer seatId;     //信息所属座位信息ID
    private Integer status = 0;     // 指定排期 指定座位 状态  0 可选 1 已选 2 已售  默认为 0

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
