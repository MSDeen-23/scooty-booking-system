package com.example.scootybookingsystem.repository;

import com.example.scootybookingsystem.model.Outlet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends MongoRepository<Outlet, String> {
}
