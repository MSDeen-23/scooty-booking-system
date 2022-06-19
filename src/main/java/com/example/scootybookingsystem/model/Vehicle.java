package com.example.scootybookingsystem.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "vehicle")
@Builder
public class Vehicle {
    @Id
    private String id;
    private VehicleSpecifications specifications;
    private Outlet currentOutlet;
    private Boolean isAvailable;

}
