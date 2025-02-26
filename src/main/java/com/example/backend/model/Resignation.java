package com.example.backend.model;

import com.example.backend.enums.ResignationStatus;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Resignation {

    private int resignationID; 

    private EmployeeApplication employeeApplication;  

    private String resignReason;  

    private LocalDateTime lastWorkingDate;  

    private ResignationStatus status; 
}