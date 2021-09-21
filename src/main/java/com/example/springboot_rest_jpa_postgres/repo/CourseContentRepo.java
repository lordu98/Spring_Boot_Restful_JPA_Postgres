package com.example.springboot_rest_jpa_postgres.repo;

import com.example.springboot_rest_jpa_postgres.entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseContentRepo extends JpaRepository<CourseContent, Integer> {

    CourseContent findByContent(String content);

}
