package com.sapient.parkingsystem.repositories;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sapient.parkingsystem.entites.ParkingBooking;

import lombok.NonNull;

/**
 * CrudRepository ParkingBooking
 */
public interface ParkingBookingRepo extends CrudRepository<ParkingBooking, Integer> {

    @Query(value = "SELECT * FROM ParkingBooking u WHERE u.parkingId = :parkingId "
        + "AND 1 = (CASE recurringPeriod "
        + "when 'MONTHLY' and DAY(u.bookingDate) = DAY(:bookingDate) then 1 "
        + "when 'WEEKLY' and WEEKDAY(u.bookingDate) = WEEKDAY(:bookingDate) then 1 "
        + "when 'DAILY' then 1 "
        + "when 'NONE' then 0 "
        + "ELSE 0 "
        + "END ) "
        + "AND (u.startTime between :bookingStartTime and :bookingStartTime "
        + "or u.endTime between :bookingStartTime and :bookingEndTime)",
        nativeQuery = true)
    List<ParkingBooking> searchBooking(@Param("parkingId") @NonNull final Integer parkingId,
        @Param("bookingDate") @NonNull final Date bookingDate,
        @Param("bookingStartTime") @NonNull final LocalTime bookingStartTime,
        @Param("bookingEndTime") @NonNull final LocalTime bookingEndTime);
}
