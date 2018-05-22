package com.rogercw.domain;

import java.io.Serializable;

/**
 * Created by 1 on 2018/5/18.
 */
public class Card implements Serializable{

    private int id;
    private String code;

    public Card() {
    }

    public Card(int id, String code) {
        this.id = id;
        this.code = code;
    }

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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
