package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.backend.enums.ApplicationStatus;
import com.example.backend.enums.ApplicationType;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@Document(collection = "applications")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {

    @Id
    private String applicationID;  

    @DBRef
    private User managedBy;

    @NotNull(message = "Application type is required")
    private ApplicationType applicationType;

    private String description;

    @NotNull(message = "Created at is required")
    private LocalDateTime createdAt;

    @NotNull(message = "Status is required")
    private ApplicationStatus status; 

    @NotNull(message = "Date from is required")
    private LocalDateTime dateFrom;  

    @NotNull(message = "Date to is required")
    private LocalDateTime dateTo;
}