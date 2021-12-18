package com.sapient.parkingsystem.model.response;

import java.util.List;

import com.sapient.parkingsystem.entites.ParkingSpot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
@AllArgsConstructor
public class ViewParkingSpotResponse {

    @NonNull
    private List<ParkingSpot> parkingSpots;
}
