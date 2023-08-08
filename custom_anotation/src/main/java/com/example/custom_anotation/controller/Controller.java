package com.example.custom_anotation.controller;

import com.example.custom_anotation.employee.Employee;
import com.example.custom_anotation.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addNewEmployeeToSystem(@Valid @RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }
    @GetMapping("/get-by-id")
    public Employee getEmployeesById(@RequestParam  Integer id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/get-all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/get-sorted")
    public List<Employee> getSortedAgeEmployees(){
        return employeeService.getSortedAgeEmployees();
    }
    @GetMapping("/same-name")
    public List<Employee> getSameNameEmployees(@RequestParam String name){
        return employeeService.getSameNameEmployees(name);
    }
    @GetMapping("/same-type")
    public List<Employee> getSameTypeEmployees(@RequestParam String type){
        return employeeService.getSameTypeEmployees(type);
    }
    @GetMapping("/same-age")
    public List<Employee> getSameAgeEmployees(@RequestParam Integer age){
        return employeeService.getSameAgeEmployee(age);
    }
}
