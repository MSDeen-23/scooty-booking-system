package com.example.scootybookingsystem.repository.customRepo;

import com.example.scootybookingsystem.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleCustomRepo  {
    public List<Vehicle> getAllVehiclesInTheOutlet(String outletId);
}
