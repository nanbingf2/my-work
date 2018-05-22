package com.rogercw.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 2018/5/14.
 */
@Entity
@Table(name = "course",schema = "hibernate")
public class Course {
    private int courseId;
    private String courseName;
    private Set<Student> students=new HashSet<Student>();

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "courses")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        return result;
    }
}
