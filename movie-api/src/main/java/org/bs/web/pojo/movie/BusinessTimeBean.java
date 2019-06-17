package org.bs.web.pojo.movie;

import java.io.Serializable;
import java.util.Date;

public class BusinessTimeBean implements Serializable {
    private static final long serialVersionUID = 5897186372322375579L;
    private Integer id;

    private String beginTime; // 开始时间

    private String endTime; // 结束时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
