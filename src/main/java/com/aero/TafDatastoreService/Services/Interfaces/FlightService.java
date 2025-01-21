package com.aero.TafDatastoreService.Services.Interfaces;

import com.aero.TafDatastoreService.Models.Flights;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FlightService {

    List<Flights> getAllFlights();

    Flights getSingleFlight(Long flightId);

    Flights AddFlight(Flights flights);

    Flights updateFlight(Long flightId, Flights flights);

     void deleteFlight(Long flightId);
}

