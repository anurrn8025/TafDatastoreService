package com.aero.TafDatastoreService.Repositories;

import com.aero.TafDatastoreService.Models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flights,Long>{

}
