package com.sapient.parkingsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@AllArgsConstructor
@Getter
public class AddParkingSpotResponse {

    @NonNull
    private String message;
}
