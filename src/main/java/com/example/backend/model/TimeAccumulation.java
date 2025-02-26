package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@Document(collection = "timeAccumulations")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeAccumulation {

    @Id
    private String accumulationID;

    private Attendance attendance;

    private double totalHoursByDay;

    private LocalDateTime updatedAt;

}