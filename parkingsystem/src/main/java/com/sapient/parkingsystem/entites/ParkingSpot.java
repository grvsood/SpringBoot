package com.sapient.parkingsystem.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ParkingSpot {

    @Id
    @NonNull
    private Integer parkingId;

    @NonNull
    private String area;

    @NonNull
    private Integer pinCode;

    @NonNull
    private Double latitude;

    @NonNull
    private Double longitude;
}
