package com.sapient.parkingsystem.model.requests;

import com.sapient.parkingsystem.entites.ParkingBooking;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class BookParkingSpotRequest {

    @NonNull
    private ParkingBooking parkingBooking;
}
