package com.sapient.parkingsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sapient.parkingsystem.entites.ParkingSpot;

import lombok.NonNull;

public interface ParkingSpotRepo extends CrudRepository<ParkingSpot, Integer> {

    @Query(value = "SELECT * FROM ParkingSpot u WHERE u.area IN :area",
        nativeQuery = true)
    List<ParkingSpot> searchByArea(@Param("area") @NonNull final String area);
}
