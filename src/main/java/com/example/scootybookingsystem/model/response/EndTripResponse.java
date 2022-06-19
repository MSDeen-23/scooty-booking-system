package com.example.scootybookingsystem.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EndTripResponse {
    private Integer price;
    private Integer totalMinutes;
}
