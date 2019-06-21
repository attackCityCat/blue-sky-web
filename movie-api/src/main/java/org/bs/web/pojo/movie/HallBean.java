package org.bs.web.pojo.movie;

import java.io.Serializable;

public class HallBean implements Serializable {
    private static final long serialVersionUID = 5534200651643877071L;
    private Integer id;  // 主键ID
    private String name; // 放映厅名称
    private Integer typeId; // 放映厅类型ID
    private String typeName;
    private Integer seats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
