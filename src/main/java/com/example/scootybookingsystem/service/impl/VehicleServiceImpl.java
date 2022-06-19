package com.example.scootybookingsystem.service.impl;

import com.example.scootybookingsystem.exceptions.customExceptions.SaveOutletFailedException;
import com.example.scootybookingsystem.model.Outlet;
import com.example.scootybookingsystem.model.Vehicle;
import com.example.scootybookingsystem.model.request.VehicleSaveRequest;
import com.example.scootybookingsystem.repository.VehicleRepository;
import com.example.scootybookingsystem.repository.customRepo.VehicleCustomRepo;
import com.example.scootybookingsystem.service.OutletService;
import com.example.scootybookingsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleCustomRepo vehicleCustomRepo;

    @Autowired
    private OutletService outletService;
    @Override
    public ResponseEntity<Vehicle> addVehicle(VehicleSaveRequest vehicleRequest) {
        Outlet outlet = outletService.getOutlet(vehicleRequest.getCurrentOutlet()).getBody();
        Vehicle vehicle = Vehicle.builder()
                .isAvailable(vehicleRequest.getIsAvailable())
                .currentOutlet(outlet)
                .specifications(vehicleRequest.getSpecifications())
                .build();
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok().body(savedVehicle);

    }

    @Override
    public ResponseEntity<Vehicle> updateVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return ResponseEntity.ok().body(vehicle);
    }

    @Override
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return null;
    }

    @Override
    public ResponseEntity<Vehicle> getVehicle(String id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(!vehicle.isPresent()){
            throw new SaveOutletFailedException("Vehicle ");
        }
        return ResponseEntity.ok().body(vehicle.get());
    }

    @Override
    public ResponseEntity<List<Vehicle>> getAllVehiclesInTheOutlet(String outletId) {
        return ResponseEntity.ok().body(vehicleCustomRepo.getAllVehiclesInTheOutlet(outletId));
    }
}
