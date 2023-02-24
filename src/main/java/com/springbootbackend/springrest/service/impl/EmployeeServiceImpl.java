package com.springbootbackend.springrest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootbackend.springrest.exception.ResourceNotFoundException;
import com.springbootbackend.springrest.model.Employee;
import com.springbootbackend.springrest.repository.EmployeeRepository;
import com.springbootbackend.springrest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }



    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }



    @Override
    public Employee getEmployeeById(long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if(employee.isPresent()){
        //     return employee.get();
        // }else{
        //     throw new ResourceNotFoundException("Employee", "Id", id);
        // }

        return employeeRepository.findById(id).orElseThrow(()->
                                    new ResourceNotFoundException("Employee","Id",id));
    }
    
    
}
