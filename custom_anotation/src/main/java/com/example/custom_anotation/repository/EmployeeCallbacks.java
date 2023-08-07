package com.example.custom_anotation.repository;

import java.util.List;

public interface EmployeeCallbacks {
    Employee insertEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployee();
    List<Employee> sortEmployeeByAge();
    List<Employee> getAllSameTypeEmployee(String type);
    List<Employee> getAllSameNameEmployee(String name);
}
