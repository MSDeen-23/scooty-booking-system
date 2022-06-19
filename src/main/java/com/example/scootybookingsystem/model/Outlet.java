package com.example.scootybookingsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "outlet")
public class Outlet {
    @Id
    private String id;
    private Boolean isDeleted;
    private LocationCoordinates locationCoordinates;
    private int maximumAvailableSlots;
}
