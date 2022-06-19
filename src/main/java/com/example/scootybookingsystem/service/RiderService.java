package com.example.scootybookingsystem.service;


import com.example.scootybookingsystem.model.Rider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RiderService {
    public ResponseEntity<Rider> addRider(Rider rider);
    public ResponseEntity<Rider> updateRider(Rider rider);
    public ResponseEntity<List<Rider>> getAllRiders();
    public ResponseEntity<Rider> getRider(String id);
    public ResponseEntity<List<Rider>> getAllRidersInTheOutlet(String id);
}
