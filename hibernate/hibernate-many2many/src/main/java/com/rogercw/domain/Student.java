package com.rogercw.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 2018/5/14.
 */
public class Student {

    private int studentId;
    private String studentName;
    private Set<Course> courses=new HashSet<Course>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
