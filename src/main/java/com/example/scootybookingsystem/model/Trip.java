package com.example.scootybookingsystem.model;


import java.util.UUID;


public class Trip {
    private UUID id;
    private TripStatus tripStatus;
    private Vehicle vehicle;
    private User user;
    private Outlet startedOutlet;
    private Outlet endedOutlet;
    private LocationCoordinates currentLocation;
}
