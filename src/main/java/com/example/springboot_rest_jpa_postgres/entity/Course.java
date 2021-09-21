package com.example.springboot_rest_jpa_postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String courseName;

    //    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<CourseContent> courseContents = new HashSet<>();


    public void addCourseContent(CourseContent courseContent) {
        this.courseContents.add(courseContent);
//        courseContent.getCourses().add(this);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Course course = (Course) o;
//
//        return Objects.equals(id, course.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return 1702818130;
//    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "courseName = " + courseName + ")";
    }
}
