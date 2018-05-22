package com.rogercw.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 2018/5/14.
 */
public class Course {

    private int courseId;
    private String courseName;
    private Set<Student> students=new HashSet<Student>();

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set getStudents() {
        return students;
    }

    public void setStudents(Set students) {
        this.students = students;
    }
}
