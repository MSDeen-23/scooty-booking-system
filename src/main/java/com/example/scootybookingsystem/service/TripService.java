package com.example.scootybookingsystem.service;

import com.example.scootybookingsystem.model.LocationCoordinates;
import com.example.scootybookingsystem.model.Trip;
import com.example.scootybookingsystem.model.helper.NearestOutletsResponse;
import com.example.scootybookingsystem.model.request.EndTripRequest;
import com.example.scootybookingsystem.model.request.StartTripRequest;
import com.example.scootybookingsystem.model.response.EndTripResponse;
import com.example.scootybookingsystem.model.response.OutletVehicleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    public ResponseEntity<List<NearestOutletsResponse>> getNearestOutlet(LocationCoordinates locationCoordinates);
    public ResponseEntity<OutletVehicleResponse> getAvailableVehiclesInOutlet(String outletId);
    public ResponseEntity<Trip> startTrip(StartTripRequest startTripRequest);
    public ResponseEntity<EndTripResponse> endTrip(EndTripRequest endTripRequest);
}
