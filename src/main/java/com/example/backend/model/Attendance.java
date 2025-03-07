package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@Document(collection = "attendances")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attendance {

    @Id
    private String attendanceID;  

    @NotNull(message = "Check in is required")
    private LocalDateTime checkIn;  

    private LocalDateTime checkOut; 

    @NotNull(message = "Break time is required")
    @PositiveOrZero(message = "Break time must be positive or zero")
    private int breakTime;  

    @Size(max = 100, message = "Note must be less than 100 characters")
    private String note;  

    @DBRef
    private Employee employee;  

    @DBRef
    private Shifts shifts;
}