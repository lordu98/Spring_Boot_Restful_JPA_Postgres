package com.example.springboot_rest_jpa_postgres.repo;

import com.example.springboot_rest_jpa_postgres.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmployeeName(String s);

    // EmployeeName s string bn boshlanadiganlarini olib keladi
    List<Employee> findByEmployeeNameStartingWith(String s);

    // name=departmentname and age < employee age dan
    List<Employee> findByDepartmentAndAgeLessThan(String d, int age);


    // name=departmentname and age <= employee age ga
    List<Employee> findByDepartmentAndAgeLessThanEqual(String d, int age);

    // name=departmentname and age > employee age dan
    List<Employee> findByDepartmentAndAgeGreaterThan(String d, int age);

    // name=departmentname and age >= employee age ga
    List<Employee> findByDepartmentAndAgeGreaterThanEqual(String d, int age);

}
