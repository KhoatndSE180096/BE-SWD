package com.example.backend.model;

import com.example.backend.enums.RoleName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    private int roleID;  

    @NotNull(message = "Role name is required")
    private RoleName roleName;  

    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    private Set<User> users; 
}