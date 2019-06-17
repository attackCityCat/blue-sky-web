package org.bs.web.pojo;

public class SeatBean {

    private Integer id;

    private Integer hallId;

    private String row;

    private String column;

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

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
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
                ", row='" + row + '\'' +
                ", column='" + column + '\'' +
                ", isActive=" + isActive +
                ", isLovers=" + isLovers +
                '}';
    }
}
