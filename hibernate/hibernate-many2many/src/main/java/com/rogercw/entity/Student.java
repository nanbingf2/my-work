package com.rogercw.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 2018/5/14.
 */
@Entity
@Table(name = "student",schema = "hibernate")
public class Student {
    private int studentId;
    private String studentName;
    private Set<Course> courses=new HashSet<Course>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinTable(name = "sc",
            joinColumns = {@JoinColumn(name = "sid")},
            inverseJoinColumns = {@JoinColumn(name = "cid")})
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "studentName")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        return result;
    }
}
