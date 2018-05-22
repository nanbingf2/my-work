package com.rogercw.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 2018/5/19.
 */
public class Clazz implements Serializable {

    private int id;
    private String code;
    private String name;
    private Set<Student> students=new HashSet<Student>();

    public Clazz() {
    }

    public Clazz(String code, String name) {
        this.code = code;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
