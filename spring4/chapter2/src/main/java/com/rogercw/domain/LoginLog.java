package com.rogercw.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志领域
 * Created by 1 on 2018/4/4.
 */
public class LoginLog implements Serializable{
    private int userId;
    private int loginLogId;
    private String ip;
    private Date loginDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
