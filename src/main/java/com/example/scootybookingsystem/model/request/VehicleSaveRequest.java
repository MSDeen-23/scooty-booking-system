package com.example.scootybookingsystem.model.request;

import com.example.scootybookingsystem.model.Outlet;
import com.example.scootybookingsystem.model.VehicleSpecifications;
import lombok.Data;

@Data
public class VehicleSaveRequest {
    private VehicleSpecifications specifications;
    private String currentOutlet;
    private Boolean isAvailable;

}
