package com.rogercw.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 2018/5/12.
 */
public class Publishers {
    private int id;
    private String name;
    private Set<Books> books=new HashSet<>();

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
