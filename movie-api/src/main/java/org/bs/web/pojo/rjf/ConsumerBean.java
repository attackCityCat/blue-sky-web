package org.bs.web.pojo.rjf;

import java.io.Serializable;

//会员信息表
public class ConsumerBean implements Serializable {
    private static final long serialVersionUID = -7776672709893741983L;

    private   Integer   id;

    private   Integer   level;  //会员等级

    private   Double    zk;   //折扣

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getZk() {
        return zk;
    }

    public void setZk(Double zk) {
        this.zk = zk;
    }

    public ConsumerBean() {
    }

    public ConsumerBean(Integer id, Integer level, Double zk) {
        this.id = id;
        this.level = level;
        this.zk = zk;
    }

    @Override
    public String toString() {
        return "ConsumerBean{" +
                "id=" + id +
                ", level=" + level +
                ", zk=" + zk +
                '}';
    }
}
