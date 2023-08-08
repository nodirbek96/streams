package com.example.custom_anotation.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTempDatabase implements EmployeeCallbacks{
    public final List<Employee> employees= new ArrayList<>();
    @Override
    public Employee insertEmployee(Employee employee) {
        Employee e=Employee.builder()
                .id(employees.size()+1)
                .age(employee.getAge())
                .name(employee.getName())
                .type(employee.getType())
                .build();
        employees.add(e);
        return e;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employees.get(id-1);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @Override
    public List<Employee> sortEmployeeByAge() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
    }

    @Override
    public List<Employee> getAllSameTypeEmployee(String type) {
        return employees.stream()
                .filter(employee -> employee.getType().equals(type))
                .toList();
    }

    @Override
    public List<Employee> getAllSameNameEmployee(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .toList();
    }
}
