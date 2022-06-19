package com.example.scootybookingsystem.model.request;

import com.example.scootybookingsystem.model.LocationCoordinates;
import lombok.Data;

@Data
public class StartTripRequest {
    private String vehicle;
    private String rider;
    private String outlet;
    private LocationCoordinates toLocation;

}
