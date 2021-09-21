package com.example.springboot_rest_jpa_postgres.service;

import com.example.springboot_rest_jpa_postgres.entity.Employee;
import com.example.springboot_rest_jpa_postgres.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> findAllEmployeesByIds(List<Integer> ids) {
        return employeeRepo.findAllById(ids);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepo.findById(id).get();
    }

    public List<Employee> findEmployeeByName(String name) {
        return employeeRepo.findByEmployeeName(name);
    }

}
