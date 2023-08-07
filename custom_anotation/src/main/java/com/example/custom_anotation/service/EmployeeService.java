package com.example.custom_anotation.service;

import com.example.custom_anotation.repository.Employee;
import com.example.custom_anotation.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public Employee addNewEmployee(Employee employee){
        return employeeRepository.insertEmployee(employee);
    }
    public Employee getEmployeeById(Integer id){
        return employeeRepository.getEmployeeById(id);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployee();
    }
    public List<Employee> getSortedAgeEmployees(){
        return employeeRepository.sortEmployeeByAge();
    }
    public List<Employee> getSameTypeEmployees(String type){
        return employeeRepository.getAllSameTypeEmployee(type);
    }
    public List<Employee> getSameNameEmployees(String name){
        return employeeRepository.getAllSameNameEmployee(name);
    }
    public List<Employee> getSameAgeEmployee(Integer age){
        return employeeRepository.getSameAgeEmployees(age);
    }
}
