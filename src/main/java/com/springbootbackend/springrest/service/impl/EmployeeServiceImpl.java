package com.springbootbackend.springrest.service.impl;

import java.util.List;

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



    @Override
    public Employee updatEmployee(Employee employee, long id) {
        // Check if employee exist in database
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
            ()->new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        
        //Save to database
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }



    @Override
    public void deletEmployee(long id) {
        // Check wether a employee exist 
        employeeRepository.findById(id).orElseThrow(
            ()->new ResourceNotFoundException("Employee", "id", id)
        );
        employeeRepository.deleteById(id);
        
    }
    
    
}
