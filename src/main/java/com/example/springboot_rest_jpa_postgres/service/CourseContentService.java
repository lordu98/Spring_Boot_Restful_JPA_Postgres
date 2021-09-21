package com.example.springboot_rest_jpa_postgres.service;

import com.example.springboot_rest_jpa_postgres.repo.CourseContentRepo;
import com.example.springboot_rest_jpa_postgres.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseContentService {

    private CourseContentRepo courseContentRepo;

    @Autowired
    public CourseContentService(CourseContentRepo courseContentRepo) {
        this.courseContentRepo = courseContentRepo;
    }
}
