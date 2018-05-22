package com.rogercw.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 2018/5/13.
 */
@Entity
@Table(name="identitycard",schema = "hibernate")
public class Identitycard {
    private int id;
    private String cardidNo;
    private People people;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "identityCard")
    @Cascade(CascadeType.DELETE)
    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cardidNo")
    public String getCardidNo() {
        return cardidNo;
    }

    public void setCardidNo(String cardidNo) {
        this.cardidNo = cardidNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identitycard that = (Identitycard) o;

        if (id != that.id) return false;
        if (cardidNo != null ? !cardidNo.equals(that.cardidNo) : that.cardidNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cardidNo != null ? cardidNo.hashCode() : 0);
        return result;
    }
}
