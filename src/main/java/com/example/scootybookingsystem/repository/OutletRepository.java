package com.example.scootybookingsystem.repository;

import com.example.scootybookingsystem.model.Outlet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OutletRepository extends MongoRepository<Outlet, String> {
}
