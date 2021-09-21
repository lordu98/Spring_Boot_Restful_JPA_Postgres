package com.example.springboot_rest_jpa_postgres;

import com.example.springboot_rest_jpa_postgres.entity.Course;
import com.example.springboot_rest_jpa_postgres.entity.CourseContent;

public class Test {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.setCourseName("JAVA");

        CourseContent content1 = new CourseContent();
        content1.setContent("content 1");
        CourseContent content2 = new CourseContent();
        content2.setContent("content 2");
        CourseContent content3 = new CourseContent();
        content3.setContent("content 3");

        System.out.println(course1.getCourseContents().add(content1));
        System.out.println(course1.getCourseContents().add(content2));
        System.out.println(course1.getCourseContents().add(content3));



        //        CourseeTest course1 = new CourseeTest();
//        course1.setName("JAVA");
//
//        ContentTest content1 = new ContentTest();
//        content1.setContent("content 1");
//        ContentTest content2 = new ContentTest();
//        content2.setContent("content 2");
//        ContentTest content3 = new ContentTest();
//        content3.setContent("content 3");
//
//        System.out.println(course1.getContents().add(content1));
//        System.out.println(course1.getContents().add(content2));
//        System.out.println(course1.getContents().add(content3));
    }
}
