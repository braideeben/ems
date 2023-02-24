package com.springbootbackend.springrest.service;

import java.util.List;

import com.springbootbackend.springrest.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);
}
