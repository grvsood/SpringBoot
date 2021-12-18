package com.sapient.parkingsystem.controllers;

import static com.sapient.parkingsystem.contants.EndpointUrls.PING;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value = PING, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String healthCheck() {

        return "Success";
    }
}
