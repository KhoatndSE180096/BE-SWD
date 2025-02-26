package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.backend.enums.PeriodType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@Document(collection = "periods")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Period {

    @Id
    private String periodID; 

    @NotNull(message = "Period type is required")
    private PeriodType periodType; 

    @NotNull(message = "Year is required")
    private int year;

    @NotNull(message = "Total weeks worked is required")
    @PositiveOrZero(message = "Total weeks worked must be positive or zero")
    private int totalWeeksWorked;

    @NotNull(message = "Total months worked is required")
    @PositiveOrZero(message = "Total months worked must be positive or zero")
    private int totalMonthsWorked;

    @NotNull(message = "Total hours is required")
    private double totalHours; 

    @NotNull(message = "Updated at is required")
    private LocalDateTime updatedAt;

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

}