package com.example.backend.model;

import lombok.Data;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeAccumulationPeriod {

    private int tapid;  

    private TimeAccumulation timeAccumulation;  

    private Period period;  
}