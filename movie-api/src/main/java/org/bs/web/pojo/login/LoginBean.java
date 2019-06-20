package org.bs.web.pojo.login;

import java.io.Serializable;

/**
 * @author Lenovo
 * @title: LoginBean
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/2010:31
 */
public class LoginBean implements Serializable {
    private static final long serialVersionUID = -7152587427450426800L;

    private Integer id;

    private String account;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
