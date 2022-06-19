package com.example.scootybookingsystem.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "vehicle")
public class Vehicle {
    private UUID id;
    private String registrationNumber;
    private String color;
    private Outlet currentOutlet;
    private Boolean isAvailable;

}
