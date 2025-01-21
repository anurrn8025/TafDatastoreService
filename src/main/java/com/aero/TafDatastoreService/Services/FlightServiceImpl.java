package com.aero.TafDatastoreService.Services;

import com.aero.TafDatastoreService.Models.Flights;
import com.aero.TafDatastoreService.Repositories.FlightsRepository;
import com.aero.TafDatastoreService.Services.Interfaces.FlightService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightsRepository flightsRepository;

    public FlightServiceImpl(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    @Override
    public List<Flights> getAllFlights() {
        System.out.println("get all flight details");
        return flightsRepository.findAll();
    }

    @Override
    public Flights getSingleFlight(Long flightId) {
        System.out.println("get single flight details");
        return flightsRepository.findById(flightId).orElse(null);
    }

    @Override
    public Flights AddFlight(Flights flights) {
        System.out.println("Add new flight");
        return flightsRepository.save(flights);
    }

    @Override
    public Flights updateFlight(Long flightId, Flights flights) {
        System.out.println("Update existing flight details");
        System.out.println("flightId is = "+ flightId);

        Optional<Flights> existingFlight = flightsRepository.findById(flightId);

        if (existingFlight.isPresent()) {
            Flights upFlight = existingFlight.get();
            upFlight.setFlight_number(flights.getFlight_number());
            upFlight.setDeparture(flights.getDeparture());
            upFlight.setArrival(flights.getArrival());
            upFlight.setDeparture_time(flights.getDeparture_time());
            upFlight.setArrival_time(flights.getArrival_time());
            upFlight.setPrice(flights.getPrice());
            upFlight.setAvailable_seats(flights.getAvailable_seats());
            upFlight.setCreated_at(flights.getCreated_at());
            upFlight.setUpdated_at(flights.getUpdated_at());

            return flightsRepository.save(upFlight);

        }
        else{
            new RuntimeException("Flight does not exists");
            return null;
        }

    }

    @Override
    public void deleteFlight(Long flightId) {
        System.out.println("delete existing flight ");
        flightsRepository.deleteById(flightId);
    }
}
