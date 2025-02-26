package com.example.backend.model;

import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeApplication {

    private int eaid;  

    private Employee employee; 

    private Application application;  

    private Resignation resignation;  
}