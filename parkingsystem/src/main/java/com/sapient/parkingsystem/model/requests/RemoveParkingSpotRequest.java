package com.sapient.parkingsystem.model.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class RemoveParkingSpotRequest {

    @NonNull
    private Integer parkingId;
}
