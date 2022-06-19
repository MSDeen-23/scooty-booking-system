package com.example.scootybookingsystem.service;

import com.example.scootybookingsystem.model.Vehicle;
import com.example.scootybookingsystem.model.request.VehicleSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    public ResponseEntity<Vehicle> addVehicle(VehicleSaveRequest vehicle);
    public ResponseEntity<Vehicle> updateVehicle(Vehicle vehicle);
    public ResponseEntity<List<Vehicle>> getAllVehicles();
    public ResponseEntity<Vehicle> getVehicle(String id);
    public ResponseEntity<List<Vehicle>> getAllVehiclesInTheOutlet(String id);
}
