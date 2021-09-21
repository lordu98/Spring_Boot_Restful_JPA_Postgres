package com.example.springboot_rest_jpa_postgres.service;

import com.example.springboot_rest_jpa_postgres.dto.CourseDto;
import com.example.springboot_rest_jpa_postgres.entity.Course;
import com.example.springboot_rest_jpa_postgres.entity.CourseContent;
import com.example.springboot_rest_jpa_postgres.repo.CourseContentRepo;
import com.example.springboot_rest_jpa_postgres.repo.CourseRepo;
import com.example.springboot_rest_jpa_postgres.utills.DtoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {

    CourseRepo courseRepo;
    CourseContentRepo courseContentRepo;

    DtoService dtoService;

    @Autowired
    public CourseService(CourseRepo courseRepo, CourseContentRepo courseContentRepo, DtoService dtoService) {
        this.courseRepo = courseRepo;
        this.courseContentRepo = courseContentRepo;
        this.dtoService = dtoService;
    }

    public Course addCourseWithContents(CourseDto courseDto) {
        try {
            Course course = new Course();
            if (courseDto.getId()!=null){
                Optional<Course> byId = courseRepo.findById(courseDto.getId());
                course=byId.get();
            }
            course.setCourseName(courseDto.getCourseName());
//            if (course.getCourseContents() == null) {
//                course.setCourseContents(new HashSet<>());
//            }
            Course finalCourse = course;
            courseDto.getCourseContents()
                    .forEach(item -> {
                        CourseContent ccontent = courseContentRepo.findByContent(item.getContent());
                        if (ccontent == null) {
                            ccontent = new CourseContent();
//                            ccontent.setCourses(new HashSet<>());
                            ccontent.setContent(item.getContent());
                        }
                        ccontent.getCourses().add(finalCourse);
                        finalCourse.getCourseContents().add(ccontent);
                    });

            Course save = courseRepo.save(course);
//            CourseDto courseDto1 = dtoService.courseToCourseDto(save);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


















}
