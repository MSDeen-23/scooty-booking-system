package com.example.scootybookingsystem.controller;

import com.example.scootybookingsystem.model.LocationCoordinates;
import com.example.scootybookingsystem.model.Trip;
import com.example.scootybookingsystem.model.helper.NearestOutletsResponse;
import com.example.scootybookingsystem.model.request.EndTripRequest;
import com.example.scootybookingsystem.model.request.StartTripRequest;
import com.example.scootybookingsystem.model.response.EndTripResponse;
import com.example.scootybookingsystem.model.response.OutletVehicleResponse;
import com.example.scootybookingsystem.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trip")
public class TripController {

    @Autowired
    TripService tripService;
    @GetMapping("/nearestOutlet")
    private ResponseEntity<List<NearestOutletsResponse>> getNearestOutlet(@RequestParam Double x, @RequestParam Double y){
        LocationCoordinates locationCoordinates = LocationCoordinates.builder()
                .x(x)
                .y(y)
                .build();
        return tripService.getNearestOutlet(locationCoordinates);
    }

    @GetMapping("/availableVehicles")
    private ResponseEntity<OutletVehicleResponse> getAvailableVehiclesInOutlet(@RequestParam String outletId){
        return tripService.getAvailableVehiclesInOutlet(outletId);

    }

    @PostMapping("/startTrip")
    private ResponseEntity<Trip> startTrip(@RequestBody StartTripRequest startTripRequest){
        return tripService.startTrip(startTripRequest);

    }

    @PostMapping("/endTrip")
    private ResponseEntity<EndTripResponse> endTrip(@RequestBody EndTripRequest endTripRequest){
        return tripService.endTrip(endTripRequest);

    }
}
