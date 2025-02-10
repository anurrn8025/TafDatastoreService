package com.aero.TafDatastoreService.Controller;
import com.aero.TafDatastoreService.Models.Flights;
import com.aero.TafDatastoreService.Models.Users;

import com.aero.TafDatastoreService.Services.FlightServiceImpl;
import com.aero.TafDatastoreService.Services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FlightController {

    //CRUD Methods for flight MS
    private final FlightServiceImpl flightServiceImpl;

    @GetMapping("/flights")

    public List<Flights> getAllFlights(){
        return flightServiceImpl.getAllFlights();
    }

    @GetMapping("/flights/{flightId}")
    public Flights getSingleFlight(@PathVariable("flightId")Long flightId){
        return flightServiceImpl.getSingleFlight(flightId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/flights/{departure}/{arrival}")
    public Flights getFlightID(@PathVariable("departure")String departure,@PathVariable("arrival")String arrival){
        return flightServiceImpl.getFlightID(departure,arrival);
    }

    @PostMapping("/flights")
    public Flights AddFlight(@RequestBody Flights flights){
        return flightServiceImpl.AddFlight(flights);
    }

    @PutMapping("/flights/{flightId}")
    public ResponseEntity<Flights> updateFlight(@PathVariable("flightId")Long flightId,@RequestBody Flights flights){

        return new ResponseEntity<>(flightServiceImpl.updateFlight(flightId,flights), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/flights/{flightId}")
    public void deleteFlight(@PathVariable("flightId")Long flightId){

        flightServiceImpl.deleteFlight(flightId);
    }

    @ExceptionHandler
    public ResponseEntity<?> respondWithError(Exception e){
        return new ResponseEntity<>("Exception Occurred. More Info :"
                + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
