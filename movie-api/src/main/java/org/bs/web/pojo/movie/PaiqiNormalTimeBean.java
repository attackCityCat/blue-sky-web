package org.bs.web.pojo.movie;

import java.io.Serializable;

public class PaiqiNormalTimeBean implements Serializable {
    private static final long serialVersionUID = 8219612572634629842L;
    private Integer id;
    private String beginTime; // 计费时间段开始时间
    private String endTime; // 计费时间段结束时间
    private float coe; // 计费系数

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

    public float getCoe() {
        return coe;
    }

    public void setCoe(float coe) {
        this.coe = coe;
    }
}
