package com.example.springboot_rest_jpa_postgres.repo;

import com.example.springboot_rest_jpa_postgres.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {


}
