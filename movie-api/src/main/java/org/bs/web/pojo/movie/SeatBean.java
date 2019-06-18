package org.bs.web.pojo.movie;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


public class SeatBean implements Serializable {

    private static final long serialVersionUID = 7206772350302578184L;
    private Integer id;         //主键
    private Integer hallId;     //放映厅ID
    private String seatRow;         //行号
    private String seatCol;      //列号
    private Integer isActive;   //是否可用
    private Integer isLovers;   //是否为情侣座

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsLovers() {
        return isLovers;
    }

    public void setIsLovers(Integer isLovers) {
        this.isLovers = isLovers;
    }
}
