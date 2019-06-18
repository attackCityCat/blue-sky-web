package org.bs.web.pojo;

public class SeatBean {

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
