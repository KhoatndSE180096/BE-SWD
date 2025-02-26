package com.example.backend.model;

import com.example.backend.enums.EmployeeShiftsStatus;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeShifts {

    private int esid;  

    private Employee employee;  

    private Shifts shifts;  

    private EmployeeShiftsStatus status;  
}