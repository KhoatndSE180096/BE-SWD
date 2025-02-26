package com.example.backend.model;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    private int eventID;  

    @NotNull(message = "Title is required")
    @Size(max = 20, message = "Title must be less than 20 characters")
    private String title;  

    @NotNull(message = "Event type is required")
    @Size(max = 20, message = "Event type must be less than 20 characters")
    private String eventType;  

    @NotNull(message = "Content is required")
    @Size(max = 255, message = "Content must be less than 255 characters")
    private String content;  

    @NotNull(message = "Date created is required")
    private LocalDateTime dateCreated;  

    private User createdBy;
}