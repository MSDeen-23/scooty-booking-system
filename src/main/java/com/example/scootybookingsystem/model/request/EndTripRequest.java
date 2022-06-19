package com.example.scootybookingsystem.model.request;

import com.example.scootybookingsystem.model.LocationCoordinates;
import com.example.scootybookingsystem.model.Outlet;
import lombok.Data;

@Data
public class EndTripRequest {
    private String id;
    private String outlet;
}
