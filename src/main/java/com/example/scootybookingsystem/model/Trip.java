package com.example.scootybookingsystem.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "trip")
public class Trip {
    @Id
    private String id;
    private TripStatus tripStatus;
    private Vehicle vehicle;
    private Rider rider;
    private Outlet startedOutlet;
    private Outlet endedOutlet;
    private LocationCoordinates currentLocation;
    private long startTime;
    private long endTime;
}
