package com.example.scootybookingsystem.service.impl;

import com.example.scootybookingsystem.exceptions.customExceptions.NotFoundException;
import com.example.scootybookingsystem.exceptions.customExceptions.OutletsNotAddedException;
import com.example.scootybookingsystem.exceptions.customExceptions.SaveOutletFailedException;
import com.example.scootybookingsystem.model.Outlet;
import com.example.scootybookingsystem.repository.OutletRepository;
import com.example.scootybookingsystem.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class OutletServiceImpl implements OutletService {

    @Autowired
    private OutletRepository outletRepository;
    @Override
    public ResponseEntity<Outlet> addOutlet(Outlet outlet) {
        try {
            Outlet savedOutlet = outletRepository.save(outlet);
            return ResponseEntity.ok().body(savedOutlet);
        }
        catch (Exception e){
            throw new SaveOutletFailedException("");
        }
    }

    @Override
    public ResponseEntity<Outlet> updateOutlet(Outlet outlet) {
        return null;
    }

    @Override
    public ResponseEntity<List<Outlet>> getAllOutlets() {
        List outlet = outletRepository.findAll();
        if(outlet.size()==0){
            throw new OutletsNotAddedException("No outlets present in the system");
        }
        else{
            return ResponseEntity.ok().body(outlet);
        }
    }

    @Override
    public ResponseEntity<Outlet> getOutlet(String id) {
        Optional<Outlet> outlet = outletRepository.findById(id);
        if(outlet.isPresent()){
            return ResponseEntity.ok().body(outlet.get());
        }else{
            throw new NotFoundException("Outlet");
        }
    }
}
