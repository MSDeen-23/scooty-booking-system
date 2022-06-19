package com.example.scootybookingsystem.repository;

import com.example.scootybookingsystem.model.Rider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiderRepository extends MongoRepository<Rider,String> {
}
