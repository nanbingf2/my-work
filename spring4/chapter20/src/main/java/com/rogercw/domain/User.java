package com.rogercw.domain;

/**
 * Created by 1 on 2018/5/11.
 */
public class User {
    private int uId;
    private String username;
    private String password;

    public User() {
    }

    public User(int uId, String username, String password) {
        this.uId = uId;
        this.username = username;
        this.password = password;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
