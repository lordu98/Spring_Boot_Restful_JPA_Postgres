package com.example.springboot_rest_jpa_postgres.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class CourseDto {
    private Integer id;
    private String courseName;
    private Set<CourseContentDto> courseContents;
}
