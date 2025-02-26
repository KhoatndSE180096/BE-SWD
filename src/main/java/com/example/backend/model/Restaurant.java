package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.backend.enums.RestaurantStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Data
@Document(collection = "restaurants")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {

    @Id
    private String restaurantID;  

    @NotNull(message = "Location is required")
    @Size(max = 255, message = "Location must be less than 255 characters")
    private String location;

    @NotNull(message = "Rating is required")
    @Size(max = 100, message = "Rating must be less than 100 characters")
    private String rating;

    @NotNull(message = "Status is required")
    private RestaurantStatus status; 

    @DBRef
    private Set<Employee> employees;  
}