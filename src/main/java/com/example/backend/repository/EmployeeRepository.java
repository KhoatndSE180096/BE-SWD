package com.example.backend.repository;

import com.example.backend.model.Employee;
import com.example.backend.enums.EmployeeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByUsername(String username);  
    Employee findByEmail(String email);  
    List<Employee> findByStatus(EmployeeStatus status);  
}