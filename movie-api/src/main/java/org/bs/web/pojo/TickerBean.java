package org.bs.web.pojo;

public class TickerBean {

    private String phone;

    private String code ;

    private Integer status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TickerBean{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
