package com.sapient.parkingsystem.model.requests;

import com.sapient.parkingsystem.entites.ParkingSpot;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UpdateParkingSpotRequest {

    @NonNull
    private ParkingSpot parkingSpot;
}
