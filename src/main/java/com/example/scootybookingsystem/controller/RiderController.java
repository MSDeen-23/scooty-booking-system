package com.example.scootybookingsystem.controller;

import com.example.scootybookingsystem.model.Rider;
import com.example.scootybookingsystem.repository.RiderRepository;
import com.example.scootybookingsystem.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rider")
public class RiderController {
    @Autowired
    private RiderService riderService;
    @PostMapping("")
    private ResponseEntity<Rider> addRider(@RequestBody Rider rider){
        return riderService.addRider(rider);
    }
}
