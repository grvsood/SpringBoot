package com.sapient.parkingsystem.controllers;

import static com.sapient.parkingsystem.contants.EndpointUrls.ADD_PARKING_SPOT;
import static com.sapient.parkingsystem.contants.EndpointUrls.ADMIN;
import static com.sapient.parkingsystem.contants.EndpointUrls.REMOVE_PARKING_SPOT;
import static com.sapient.parkingsystem.contants.EndpointUrls.UPDATE_PARKING_SPOT;
import static com.sapient.parkingsystem.contants.EndpointUrls.VIEW_BOOKINGS;
import static com.sapient.parkingsystem.contants.EndpointUrls.VIEW_PARKING_SPOT;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.parkingsystem.model.requests.AddParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.RemoveParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.UpdateParkingSpotRequest;
import com.sapient.parkingsystem.model.requests.ViewParkingSpotRequest;
import com.sapient.parkingsystem.model.response.AddParkingSpotResponse;
import com.sapient.parkingsystem.model.response.RemoveParkingSpotResponse;
import com.sapient.parkingsystem.model.response.UpdateParkingSpotResponse;
import com.sapient.parkingsystem.model.response.ViewParkingBookingsRespnose;
import com.sapient.parkingsystem.model.response.ViewParkingSpotResponse;

import lombok.NonNull;

@RestController
@RequestMapping(ADMIN)
public class AdminController extends BaseController {

    /**
     * Adds the parking spot in the Mysql DB
     * @param addParkingSpotRequest
     * @return
     */
    @PostMapping(value = ADD_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AddParkingSpotResponse addParkingSpot(
        @RequestBody @Valid @NonNull final AddParkingSpotRequest addParkingSpotRequest) {

        return parkingService.addParkingSpot(addParkingSpotRequest);
    }

    /**
     * View all Parking spots available in DB
     * @return
     */
    @GetMapping(value = VIEW_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ViewParkingSpotResponse viewAllParkingSpots() {

        return parkingService.viewParkingSpots(
            ViewParkingSpotRequest.builder().parkingSpotId(Collections.emptyList()).build());
    }

    /**
     * Remove a parking spot by ID
     * @param request
     * @return
     */
    @PostMapping(value = REMOVE_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RemoveParkingSpotResponse removeParkingSpot(
        @RequestBody @Valid @NonNull final RemoveParkingSpotRequest request) {

        return parkingService.removeParkingSpot(request);
    }

    /**
     * Update a parking spot, only if it exists
     * @param request
     * @return
     */
    @PostMapping(value = UPDATE_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UpdateParkingSpotResponse updateParkingSpot(
        @RequestBody @Valid @NonNull final UpdateParkingSpotRequest request) {

        return parkingService.updateParkingSpot(request);
    }

    /**
     * View all bookings in the system
     * @return
     */
    @GetMapping(value = VIEW_BOOKINGS, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ViewParkingBookingsRespnose viewAllParkingBookings(){

        return parkingService.viewBookings();
    }
}
