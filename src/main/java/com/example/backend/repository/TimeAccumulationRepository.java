package com.example.backend.repository;

import com.example.backend.model.TimeAccumulation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeAccumulationRepository extends MongoRepository<TimeAccumulation, String> {
}