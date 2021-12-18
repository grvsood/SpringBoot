package com.sapient.parkingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.parkingsystem.service.ParkingService;

public abstract class BaseController {

    @Autowired
    protected ParkingService parkingService;
}
