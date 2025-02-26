package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Data
@Document(collection = "shifts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shifts {

    @Id
    private String shiftsID;  

    @DBRef
    private Employee employee;  

    @DBRef
    private User createdBy;  

    @NotNull(message = "Shift name is required")
    @Size(max = 255, message = "Shift name must be less than 255 characters")
    private String shiftName;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    private LocalDateTime endTime;

    @NotNull(message = "Break duration is required")
    @PositiveOrZero(message = "Break duration must be positive or zero")
    private int breakDuration;

    private Set<EmployeeShifts> employeeShifts;
}