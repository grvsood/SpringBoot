package com.sapient.parkingsystem.model.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ViewParkingSpotRequest {

    // if null, it will return all parking spots
    private List<Integer> parkingSpotId;
}
