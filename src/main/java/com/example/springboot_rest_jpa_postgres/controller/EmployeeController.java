package com.example.springboot_rest_jpa_postgres.controller;

import com.example.springboot_rest_jpa_postgres.dto.CityDto;
import com.example.springboot_rest_jpa_postgres.dto.CourseDto;
import com.example.springboot_rest_jpa_postgres.entity.City;
import com.example.springboot_rest_jpa_postgres.entity.Course;
import com.example.springboot_rest_jpa_postgres.entity.Employee;
import com.example.springboot_rest_jpa_postgres.repo.EmployeeRepo;
import com.example.springboot_rest_jpa_postgres.service.CityService;
import com.example.springboot_rest_jpa_postgres.service.CourseService;
import com.example.springboot_rest_jpa_postgres.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("addemployees")
    public ResponseEntity<?> addAllEmployees(@RequestBody List<Employee> employees) {
        List<Employee> employees1 = employeeService.saveAllEmployees(employees);
        return ResponseEntity.status(employees1.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(employees1);
    }

    @GetMapping("allemployees")
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> employees1 = employeeService.findAllEmployees();
        return ResponseEntity.status(employees1.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(employees1);
    }

    @GetMapping("employeeswithname")
    public ResponseEntity<?> getAllEmployeesWithName(@RequestParam String employeename) {
        List<Employee> employees1 = employeeService.findEmployeeByName(employeename);
        return ResponseEntity.status(employees1.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(employees1);
    }

    @GetMapping("employeebyid")
    public ResponseEntity<?> getEmployeeById(@RequestParam int id) {
        Employee employeeById = employeeService.findEmployeeById(id);
        return ResponseEntity.status(employeeById==null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(employeeById);
    }

    @GetMapping("employeesybyids")
    public ResponseEntity<?> getEmployeesByIds(@RequestParam List<Integer> ids) {
        List<Employee> allEmployeesByIds = employeeService.findAllEmployeesByIds(ids);
        return ResponseEntity.status(allEmployeesByIds==null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(allEmployeesByIds);
    }

    @GetMapping("empbydeptandage")
    public ResponseEntity<?> getEmpByDeptAndAge(@RequestParam String d,
                                                      @RequestParam int age) {
        List<Employee> allEmployeesByIds = employeeRepo.findByDepartmentAndAgeLessThan(d,age);
        return ResponseEntity.status(allEmployeesByIds==null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(allEmployeesByIds);
    }

    @GetMapping("empbydeptandageequal")
    public ResponseEntity<?> getEmpByDeptAndAgeEqual(@RequestParam String d,
                                                      @RequestParam int age) {
        List<Employee> allEmployeesByIds = employeeRepo.findByDepartmentAndAgeLessThanEqual(d,age);
        return ResponseEntity.status(allEmployeesByIds==null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(allEmployeesByIds);
    }

}
