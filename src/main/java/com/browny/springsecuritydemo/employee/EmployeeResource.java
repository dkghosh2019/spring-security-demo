package com.browny.springsecuritydemo.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeResource {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "Beejan Bardhan"),
            new Employee(2, "James Jones"),
            new Employee(3, "Maria Lee"),
            new Employee(4, "Jackie Smith"),
            new Employee(5, "Amy Sharine")
    );

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Integer id){
        return employees.stream()
                .filter(employee -> id == employee.getId())
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Employee with id : " + id + " not found"));
    }
}
