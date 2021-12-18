package com.sapient.parkingsystem.controllers;

import static com.sapient.parkingsystem.contants.EndpointUrls.BOOK_PARKING_SPOT;
import static com.sapient.parkingsystem.contants.EndpointUrls.BULKBOOK_PARKING_SPOT;
import static com.sapient.parkingsystem.contants.EndpointUrls.SEARHC_PARKING_SPOT;
import static com.sapient.parkingsystem.contants.EndpointUrls.USER;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.parkingsystem.model.requests.BookParkingSpotRequest;
import com.sapient.parkingsystem.model.response.BookParkingSpotResponse;
import com.sapient.parkingsystem.model.response.ViewParkingSpotResponse;

import lombok.NonNull;

@RestController
@RequestMapping(USER)
public class UserController extends BaseController {

    /**
     * user can book parking using this controller
     * @param request
     * @return
     */
    @PostMapping(value = BOOK_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BookParkingSpotResponse bookParkingSpot(@RequestBody @Valid @NonNull final BookParkingSpotRequest request) {

        return parkingService.bookParkingSpot(request);
    }

    /**
     * Search for particular parking location by area
     * @param area
     * @return
     */
    @GetMapping(value = SEARHC_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ViewParkingSpotResponse searchByLocation(@PathParam("area") @NonNull final String area) {

        return parkingService.searchParkingSpot(area);
    }

    /**
     * Bulk Book parking spots
     * @param requests
     * @return
     */
    @PostMapping(value = BULKBOOK_PARKING_SPOT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<BookParkingSpotResponse> bulkBookParkingSpot(
        @RequestBody @Valid @NonNull final List<BookParkingSpotRequest> requests) {

        return parkingService.bulkBookParkingSpot(requests);
    }
}
