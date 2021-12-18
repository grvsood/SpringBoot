package com.sapient.parkingsystem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sapient.parkingsystem.contants.ParkingConstants;
import com.sapient.parkingsystem.dao.MySqlDao;
import com.sapient.parkingsystem.entites.ParkingBooking;
import com.sapient.parkingsystem.entites.ParkingSpot;
import com.sapient.parkingsystem.model.requests.AddParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.BookParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.RemoveParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.UpdateParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.ViewParkingSpotRequest;
import com.sapient.parkingsystem.model.response.AddParkingSpotResponse;
import com.sapient.parkingsystem.model.response.BookParkingSpotResponse;
import com.sapient.parkingsystem.model.response.RemoveParkingSpotResponse;
import com.sapient.parkingsystem.model.response.UpdateParkingSpotResponse;
import com.sapient.parkingsystem.model.response.ViewParkingBookingsRespnose;
import com.sapient.parkingsystem.model.response.ViewParkingSpotResponse;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParkingService {

    @Autowired
    private MySqlDao mySqlDao;

    public AddParkingSpotResponse addParkingSpot(
        @NonNull final AddParkingSpotRequest request) {

        try {
            final ParkingSpot parkingSpot = request.getParkingSpot();
            final Boolean parkingExists = mySqlDao.parkingExists(parkingSpot.getParkingId());
            if (parkingExists) {
                return AddParkingSpotResponse
                    .builder()
                    .message("Parking Location Already Exists")
                    .build();
            }

            mySqlDao.addParkingSpot(parkingSpot);
            return AddParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.SUCCESS.getResponse())
                .build();

        } catch (Exception e) {
            log.error("unable to add new parking spot", e);
            return AddParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.ERROR.getResponse())
                .build();
        }
    }

    public ViewParkingSpotResponse viewParkingSpots(@NonNull final ViewParkingSpotRequest request) {

        List<ParkingSpot> parkingSpots;
        try {
            parkingSpots = mySqlDao.getParkingSpots(request.getParkingSpotId());
        } catch (Exception e) {
            log.error("unable to view parking spots", e);
            parkingSpots = Collections.emptyList();
        }

        return ViewParkingSpotResponse.builder().parkingSpots(parkingSpots).build();
    }

    public RemoveParkingSpotResponse removeParkingSpot(@NonNull final RemoveParkingSpotRequest request) {

        try {
            final Boolean parkingExists = mySqlDao.parkingExists(request.getParkingId());
            if (!parkingExists) {
                return RemoveParkingSpotResponse
                    .builder()
                    .message("Unable to remove as parking location doesn't exist")
                    .build();
            }

            mySqlDao.removeParkingSpot(request.getParkingId());
            return RemoveParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.SUCCESS.getResponse())
                .build();

        } catch (Exception e) {
            log.error("Error occured to remove new parking spot", e);
            return RemoveParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.ERROR.getResponse())
                .build();
        }
    }

    public UpdateParkingSpotResponse updateParkingSpot(@NonNull final UpdateParkingSpotRequest request) {

        try {
            final Boolean parkingExists = mySqlDao.parkingExists(request.getParkingSpot().getParkingId());
            if (!parkingExists) {
                return UpdateParkingSpotResponse
                    .builder()
                    .message("Unable to update as parking location doesn't exist")
                    .build();
            }

            mySqlDao.removeParkingSpot(request.getParkingSpot().getParkingId());
            mySqlDao.addParkingSpot(request.getParkingSpot());
            return UpdateParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.SUCCESS.getResponse())
                .build();

        } catch (Exception e) {
            log.error("Error occured to udpate the parking spot", e);
            return UpdateParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.ERROR.getResponse())
                .build();
        }

    }

    public BookParkingSpotResponse bookParkingSpot(@NonNull final BookParkingSpotRequest request) {

        try {
            final ParkingBooking requestBooking = request.getParkingBooking();

            final List<ParkingBooking> existingParkingBookings =
                mySqlDao.searchBookings(requestBooking.getParkingId(),
                    requestBooking.getBookingDate(), requestBooking.getStartTime(), requestBooking.getEndTime());

            if (!CollectionUtils.isEmpty(existingParkingBookings)) {
                return BookParkingSpotResponse
                    .builder()
                    .message("Booking Cannot be accepted. Spot already booked.")
                    .build();
            }
            mySqlDao.bookParkingSpot(requestBooking);
            return BookParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.SUCCESS.getResponse())
                .build();

        } catch (Exception e) {
            log.error("Error while occurred to booking the parking spot", e);
            return BookParkingSpotResponse
                .builder()
                .message(ParkingConstants.Response.ERROR.getResponse())
                .build();
        }
    }

    public List<BookParkingSpotResponse> bulkBookParkingSpot(@NonNull final List<BookParkingSpotRequest> requests) {

        return requests.stream().map(this::bookParkingSpot).collect(Collectors.toList());
    }

    public ViewParkingSpotResponse searchParkingSpot(@NonNull final String area) {

        try {
            List<ParkingSpot> parkingSpots = mySqlDao.searchParkingLocations(area);
            return ViewParkingSpotResponse.builder().parkingSpots(parkingSpots).build();
        } catch (Exception e) {
            log.error("Error occurred to search parking spots", e);
            return ViewParkingSpotResponse.builder().build();
        }
    }

    public ViewParkingBookingsRespnose viewBookings() {

        List<ParkingBooking> parkingBookingList = new ArrayList<>();
        try {
            parkingBookingList = mySqlDao.getParkingBookings();
        } catch (Exception e) {
            log.info("Error occured to view parking bookings");
        }
        return ViewParkingBookingsRespnose.builder().parkingBookingList(parkingBookingList).build();
    }
}
