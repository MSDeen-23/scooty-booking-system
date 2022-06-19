package com.example.scootybookingsystem.repository;

import com.example.scootybookingsystem.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {
}
