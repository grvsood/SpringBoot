package com.sapient.parkingsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
@AllArgsConstructor
public class UpdateParkingSpotResponse {

    @NonNull
    private String message;
}
