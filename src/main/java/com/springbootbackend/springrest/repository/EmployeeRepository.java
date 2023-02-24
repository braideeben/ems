package com.springbootbackend.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootbackend.springrest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
