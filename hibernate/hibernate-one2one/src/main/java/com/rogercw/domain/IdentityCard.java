package com.rogercw.domain;

/**
 * Created by 1 on 2018/5/14.
 */
public class IdentityCard {

    private int id;
    private String cardidNo;
    private People people;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardidNo() {
        return cardidNo;
    }

    public void setCardidNo(String cardidNo) {
        this.cardidNo = cardidNo;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
