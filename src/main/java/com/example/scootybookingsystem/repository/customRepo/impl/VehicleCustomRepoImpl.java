package com.example.scootybookingsystem.repository.customRepo.impl;

import com.example.scootybookingsystem.model.Vehicle;
import com.example.scootybookingsystem.repository.customRepo.VehicleCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository("vehicleCustomRepo")
public class VehicleCustomRepoImpl implements VehicleCustomRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Vehicle> getAllVehiclesInTheOutlet(String outletId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("currentOutlet._id").is(outletId));
        query.addCriteria(Criteria.where("isAvailable").is(true));
        return mongoTemplate.find(query,Vehicle.class);
    }
}
