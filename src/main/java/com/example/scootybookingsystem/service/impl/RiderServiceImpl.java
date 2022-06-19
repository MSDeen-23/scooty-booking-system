package com.example.scootybookingsystem.service.impl;

import com.example.scootybookingsystem.exceptions.customExceptions.NotFoundException;
import com.example.scootybookingsystem.model.Rider;
import com.example.scootybookingsystem.repository.RiderRepository;
import com.example.scootybookingsystem.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiderServiceImpl implements RiderService {
    @Autowired
    private RiderRepository riderRepository;
    @Override
    public ResponseEntity<Rider> addRider(Rider rider) {
        Rider savedRider = riderRepository.save(rider);
        return ResponseEntity.ok().body(savedRider);
    }

    @Override
    public ResponseEntity<Rider> updateRider(Rider rider) {
        return null;
    }

    @Override
    public ResponseEntity<List<Rider>> getAllRiders() {
        return null;
    }

    @Override
    public ResponseEntity<Rider> getRider(String id) {
        Optional<Rider> rider= riderRepository.findById(id);
        if(rider.isPresent()){
            return ResponseEntity.ok().body(rider.get());
        }
        else{
            throw new NotFoundException("Rider ");
        }


    }

    @Override
    public ResponseEntity<List<Rider>> getAllRidersInTheOutlet(String id) {
        return null;
    }
}
