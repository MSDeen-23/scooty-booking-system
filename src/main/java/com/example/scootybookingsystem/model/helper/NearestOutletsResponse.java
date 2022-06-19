package com.example.scootybookingsystem.model.helper;

import com.example.scootybookingsystem.model.Outlet;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

@Data
public class NearestOutletsResponse extends Outlet {
    private Double distance;
    private int currentAvailableParkingSlots;

    public NearestOutletsResponse(Outlet outlet) {
        BeanUtils.copyProperties(outlet,this);
    }
}
