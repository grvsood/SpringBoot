package com.sapient.parkingsystem;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class ParkingsystemApplication {

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {

        SpringApplication.run(ParkingsystemApplication.class, args);
    }

    @PostConstruct
    public void setUp() {

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

}
