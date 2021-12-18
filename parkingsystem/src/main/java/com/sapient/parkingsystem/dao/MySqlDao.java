package com.sapient.parkingsystem.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.parkingsystem.entites.ParkingBooking;
import com.sapient.parkingsystem.entites.ParkingSpot;
import com.sapient.parkingsystem.repositories.ParkingBookingRepo;
import com.sapient.parkingsystem.repositories.ParkingSpotRepo;

import lombok.NonNull;

@Component
public class MySqlDao {

    @Autowired
    private ParkingSpotRepo parkingSpotRepo;

    @Autowired
    private ParkingBookingRepo parkingBookingRepo;

    public void addParkingSpot(@NonNull final ParkingSpot parkingSpot) {

        parkingSpotRepo.save(parkingSpot);
    }

    public Boolean parkingExists(@NonNull final Integer parkingId) {

        return parkingSpotRepo.existsById(parkingId);
    }

    public List<ParkingSpot> getParkingSpots(@NonNull final List<Integer> parkingSpotId) {

        final List<ParkingSpot> parkingSpots = new ArrayList<>();

        if (parkingSpotId.isEmpty()) {
            parkingSpotRepo.findAll().forEach(parkingSpots::add);
        } else {
            parkingSpotRepo.findAllById(parkingSpotId).forEach(parkingSpots::add);
        }

        return parkingSpots;
    }

    public void removeParkingSpot(@NonNull final Integer parkingSpotId) {

        parkingSpotRepo.deleteById(parkingSpotId);
    }

    public void bookParkingSpot(@NonNull final ParkingBooking booking) {

        parkingBookingRepo.save(booking);
    }

    public List<ParkingSpot> searchParkingLocations(@NonNull final String area) {

        return parkingSpotRepo.searchByArea(area);
    }

    public List<ParkingBooking> searchBookings(@NonNull final Integer parkingID, @NonNull final Date bookingDate,
        @NonNull final LocalTime startTime, @NonNull final
    LocalTime endTime) {

        return parkingBookingRepo.searchBooking(parkingID, bookingDate, startTime, endTime);
    }

    public List<ParkingBooking> getParkingBookings(){

        final List<ParkingBooking> parkingBookings = new ArrayList<>();
        parkingBookingRepo.findAll().forEach(parkingBookings::add);
        return parkingBookings;
    }
}
