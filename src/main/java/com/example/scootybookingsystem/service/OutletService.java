package com.example.scootybookingsystem.service;

import com.example.scootybookingsystem.model.Outlet;
import com.example.scootybookingsystem.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public interface OutletService {
    public ResponseEntity<Outlet> addOutlet(Outlet outlet);
    public ResponseEntity<Outlet> updateOutlet(Outlet outlet);
    public ResponseEntity<List<Outlet>> getAllOutlets();
    public ResponseEntity<Outlet> getOutlet(String id);
}
