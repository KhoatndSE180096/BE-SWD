package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.backend.enums.EmployeeStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Data
@Document(collection = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    private String employeeID;

    @NotNull(message = "Status is required")
    private EmployeeStatus status;

    @NotNull(message = "Username is required")
    @Size(max = 255, message = "Username must be less than 255 characters")
    private String username;

    @NotNull(message = "Password hash is required")
    @Size(max = 50, message = "Password hash must be less than 50 characters")
    private String passwordHash;

    @NotNull(message = "First name is required")
    @Size(max = 100, message = "First name must be less than 100 characters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(max = 100, message = "Last name must be less than 100 characters")
    private String lastName;

    @NotNull(message = "Email is required")
    @Email(message = "Email must be valid")
    @Size(max = 255, message = "Email must be less than 255 characters")
    private String email;
    
    @DBRef
    private Set<Attendance> attendances;

    @DBRef
    private Set<Shifts> shifts;
}