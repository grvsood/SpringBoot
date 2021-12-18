package com.sapient.parkingsystem.entites;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sapient.parkingsystem.contants.ParkingConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ParkingBooking {

    @Id
    private Integer userBookingId;

    @NonNull
    private String user;

    @NonNull
    private Integer parkingId;

    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date bookingDate;

    @NonNull
    private LocalTime startTime;

    @NonNull
    private LocalTime endTime;

    @NonNull
    private ParkingConstants.RecurringPeriod recurringPeriod;
}
