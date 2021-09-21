package com.example.springboot_rest_jpa_postgres.utills;

import com.example.springboot_rest_jpa_postgres.dto.CourseContentDto;
import com.example.springboot_rest_jpa_postgres.dto.CourseDto;
import com.example.springboot_rest_jpa_postgres.entity.Course;
import com.example.springboot_rest_jpa_postgres.entity.CourseContent;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DtoService {

    public CourseDto courseToCourseDto(Course course){
        return CourseDto
                .builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseContents(course.getCourseContents().stream().map(this::courseContentToCourseContentDto).collect(Collectors.toSet()))
                .build();
    }

    public CourseContentDto courseContentToCourseContentDto(CourseContent courseContent){
        return CourseContentDto
                .builder()
                .id(courseContent.getId())
                .content(courseContent.getContent())
                .courseDtos(courseContent.getCourses().stream().map(this::courseToCourseDto).collect(Collectors.toSet()))
                .build();
    }



}
