package com.example.scootybookingsystem.service.impl;

import com.example.scootybookingsystem.exceptions.customExceptions.NoNearByOutletsFoundException;
import com.example.scootybookingsystem.exceptions.customExceptions.NotFoundException;
import com.example.scootybookingsystem.exceptions.customExceptions.TripAlreadyCompletedException;
import com.example.scootybookingsystem.model.*;
import com.example.scootybookingsystem.model.helper.NearestOutletsResponse;
import com.example.scootybookingsystem.model.request.EndTripRequest;
import com.example.scootybookingsystem.model.request.StartTripRequest;
import com.example.scootybookingsystem.model.response.EndTripResponse;
import com.example.scootybookingsystem.model.response.OutletVehicleResponse;
import com.example.scootybookingsystem.repository.TripRepository;
import com.example.scootybookingsystem.service.OutletService;
import com.example.scootybookingsystem.service.RiderService;
import com.example.scootybookingsystem.service.TripService;
import com.example.scootybookingsystem.service.VehicleService;
import com.example.scootybookingsystem.utils.DateUtils;
import com.example.scootybookingsystem.utils.StrategyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private OutletService outletService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RiderService riderService;

    @Autowired
    private TripRepository tripRepository;

    @Value("${distance.radius}")
    private String radius;

    @Value("${pricePerHour}")
    private String pricePerHour;
    @Override
    public ResponseEntity<List<NearestOutletsResponse>> getNearestOutlet(LocationCoordinates locationCoordinates) {
        List<Outlet> outletList = outletService.getAllOutlets().getBody();
        List<NearestOutletsResponse> nearestOutlets = new ArrayList<>();
        outletList.stream().forEach(outlet -> {
            double distance = locationCoordinates.distance(outlet.getLocationCoordinates());
            if(distance < Double.parseDouble(radius)){
                NearestOutletsResponse nearestOutletsResponse = new NearestOutletsResponse(outlet);
                nearestOutletsResponse.setDistance(distance);
                int numberOfVehiclesPresent = vehicleService.getAllVehiclesInTheOutlet(outlet.getId()).getBody().size();
                int freeLots = outlet.getMaximumAvailableSlots()-numberOfVehiclesPresent;
                nearestOutletsResponse.setCurrentAvailableParkingSlots(freeLots);
                nearestOutlets.add(nearestOutletsResponse);
            }
        });
        nearestOutlets.sort(Comparator.comparing(NearestOutletsResponse::getDistance));
        return ResponseEntity.ok().body(nearestOutlets);
    }

    @Override
    public ResponseEntity<OutletVehicleResponse> getAvailableVehiclesInOutlet(String outletId) {
        OutletVehicleResponse outletVehicleResponse = new OutletVehicleResponse();
        Outlet outlet = outletService.getOutlet(outletId).getBody();
        BeanUtils.copyProperties(outlet,outletVehicleResponse);
        List<Vehicle> availableVehiclesInTheOutlet = vehicleService.getAllVehiclesInTheOutlet(outletId).getBody();
        outletVehicleResponse.setVehicleList(availableVehiclesInTheOutlet);
        return ResponseEntity.ok().body(outletVehicleResponse);
    }

    @Override
    public ResponseEntity<Trip> startTrip(StartTripRequest startTripRequest) {
        Trip trip = new Trip();
        List<NearestOutletsResponse> outlets = getNearestOutlet(startTripRequest.getToLocation()).getBody();
        if(outlets.size()==0){
            throw new NoNearByOutletsFoundException("No near by outlets found from the destination.");
        }
        trip.setTripStatus(TripStatus.INPROGRESS);
        Vehicle vehicle = vehicleService.getVehicle(startTripRequest.getVehicle()).getBody();
        vehicle.setIsAvailable(false);
        trip.setVehicle(vehicle);
        trip.setRider(riderService.getRider(startTripRequest.getRider()).getBody());
        trip.setStartedOutlet(outletService.getOutlet(startTripRequest.getOutlet()).getBody());
        long currentTime = DateUtils.getCurrentTime();
        trip.setStartTime(currentTime);
        Trip savedTrip = tripRepository.save(trip);
        vehicleService.updateVehicle(vehicle);
        return ResponseEntity.ok().body(savedTrip);
    }

    @Override
    public ResponseEntity<EndTripResponse> endTrip(EndTripRequest endTripRequest) {
        Optional<Trip> trip = tripRepository.findById(endTripRequest.getId());
        Outlet outlet = outletService.getOutlet(endTripRequest.getOutlet()).getBody();
        if(trip.isEmpty()){
            throw new NotFoundException("Trip ");
        }

        Trip savedTrip = trip.get();
        if(savedTrip.getTripStatus().equals(TripStatus.CLOSED)){
            throw new TripAlreadyCompletedException("Trip already completed");
        }
        Vehicle vehicle = savedTrip.getVehicle();
        vehicle.setIsAvailable(true);
        vehicle.setCurrentOutlet(outlet);
        savedTrip.setTripStatus(TripStatus.CLOSED);
        savedTrip.setEndedOutlet(outlet);
        long currentTime = DateUtils.getCurrentTime();
        savedTrip.setEndTime(currentTime);
        int price = StrategyUtils.calculatePrice(savedTrip.getStartTime(),savedTrip.getEndTime(),Integer.parseInt(pricePerHour));
        int minutes = StrategyUtils.calculateMinutes(savedTrip.getStartTime(),savedTrip.getEndTime());
        EndTripResponse endTripResponse = EndTripResponse.builder()
                .price(price)
                .totalMinutes(minutes)
                .build();
        tripRepository.save(savedTrip);
        vehicleService.updateVehicle(vehicle);
        return  ResponseEntity.ok().body(endTripResponse);

    }
}
