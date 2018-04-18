package com.rogercw.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 1 on 2018/4/4.
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private int credits;  //用户积分
    private String lastIp;  //最后登录ip
    private Date lastLogin;  //最后登录时间

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
