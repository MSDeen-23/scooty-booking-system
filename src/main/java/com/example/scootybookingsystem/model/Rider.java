package com.example.scootybookingsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "user")
public class Rider {
    @Id
    private String id;
    private String name;
}
