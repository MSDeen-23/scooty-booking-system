package com.example.scootybookingsystem.repository;

import com.example.scootybookingsystem.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends MongoRepository<Trip,String> {
}
