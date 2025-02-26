package com.example.backend.model;

import com.example.backend.enums.EmployeeStatus;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRestaurant {

    private int erid;  

    private Employee employee;  

    private Restaurant restaurant;  

    private EmployeeStatus status;  
}