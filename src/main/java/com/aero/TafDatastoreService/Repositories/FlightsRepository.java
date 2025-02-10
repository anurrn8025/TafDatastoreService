package com.aero.TafDatastoreService.Repositories;

import com.aero.TafDatastoreService.Models.Bookings;
import com.aero.TafDatastoreService.Models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights,Long>{

    Flights findByDepartureAndArrival(String departure, String arrival);
}
