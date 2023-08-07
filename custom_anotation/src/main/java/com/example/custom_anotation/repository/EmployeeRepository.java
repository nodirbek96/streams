package com.example.custom_anotation.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository extends EmployeeTempDatabase{
    public List<Employee> getSameAgeEmployees(Integer age){
        return employees.stream()
                .filter(employee -> employee.getAge().equals(age))
                .toList();
    }
}
