package org.bs.web.pojo;

import java.io.Serializable;

public class SeatBean implements Serializable {

    private static final long serialVersionUID = -927228144449148763L;
    private Integer id;

    private Integer hallId;

    private String seatRow;

    private String seatColumn;

    private Integer isActive;

    private Integer isLovers;

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

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
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

    public SeatBean(Integer id, Integer hallId, String seatRow, String seatColumn, Integer isActive, Integer isLovers) {
        this.id = id;
        this.hallId = hallId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.isActive = isActive;
        this.isLovers = isLovers;
    }

    public SeatBean() {
    }

    @Override
    public String toString() {
        return "SeatBean{" +
                "id=" + id +
                ", hallId=" + hallId +
                ", seatRow='" + seatRow + '\'' +
                ", seatColumn='" + seatColumn + '\'' +
                ", isActive=" + isActive +
                ", isLovers=" + isLovers +
                '}';
    }
}
