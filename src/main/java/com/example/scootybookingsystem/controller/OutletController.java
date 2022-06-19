package com.example.scootybookingsystem.controller;

import com.example.scootybookingsystem.model.Outlet;
import com.example.scootybookingsystem.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/outlet")
public class OutletController {

    @Autowired
    OutletService outletService;
    @PostMapping("")
    private ResponseEntity<Outlet> addOutlet(@RequestBody Outlet outlet){
        return outletService.addOutlet(outlet);
    }

}
