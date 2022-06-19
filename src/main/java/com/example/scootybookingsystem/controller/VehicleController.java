package com.example.scootybookingsystem.controller;


import com.example.scootybookingsystem.model.Vehicle;
import com.example.scootybookingsystem.model.request.VehicleSaveRequest;
import com.example.scootybookingsystem.service.VehicleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping("")
    private ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleSaveRequest vehicle){
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping()
    private ResponseEntity<List<Vehicle>> getAllVehiclesInTheOutlet(@RequestParam String vehicleId){
        return vehicleService.getAllVehiclesInTheOutlet(vehicleId);
    }

}
