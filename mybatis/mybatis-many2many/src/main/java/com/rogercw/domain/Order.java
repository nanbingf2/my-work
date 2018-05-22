package com.rogercw.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2018/5/20.
 */
public class Order implements Serializable {

    private int id;
    private String code;
    private int total;
    private User user;
    private List<Article> articles=new ArrayList<Article>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", total=" + total +
                ", user=" + user +
                ", articles=" + articles +
                '}';
    }
}
