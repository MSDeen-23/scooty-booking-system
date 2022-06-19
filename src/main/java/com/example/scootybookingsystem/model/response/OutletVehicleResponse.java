package com.example.scootybookingsystem.model.response;

import com.example.scootybookingsystem.model.Outlet;
import com.example.scootybookingsystem.model.Vehicle;
import lombok.Data;

import java.util.List;

@Data
public class OutletVehicleResponse extends Outlet {
    private List<Vehicle> vehicleList;
}
