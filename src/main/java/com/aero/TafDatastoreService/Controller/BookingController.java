package com.aero.TafDatastoreService.Controller;
import com.aero.TafDatastoreService.Models.Bookings;
import com.aero.TafDatastoreService.Models.Flights;
import com.aero.TafDatastoreService.Models.Users;

import com.aero.TafDatastoreService.Services.BookingServiceImpl;
import com.aero.TafDatastoreService.Services.FlightServiceImpl;
import com.aero.TafDatastoreService.Services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {

    //CRUD Methods for booking MS
    private final BookingServiceImpl bookingServiceImpl;

    //Get booking details for specific user
    @GetMapping("/bookings/user/{userId}")
    public List<Bookings> getAllBookingsOfUser(@PathVariable("userId")Long userId){
        return bookingServiceImpl.getAllBookingsOfUser(userId);
    }

    //Get booking details
    @GetMapping("/bookings/{bookingId}")
    public Bookings getSingleBooking(@PathVariable("bookingId")Long bookingId){
        return bookingServiceImpl.getSingleBooking(bookingId);
    }

    @PostMapping("/bookings")
    public Bookings AddBooking(@RequestBody Bookings bookings){
        return bookingServiceImpl.AddBooking(bookings);
    }

    @PatchMapping("/bookings/{bookingId}")
    public ResponseEntity<Bookings> updateBooking(@PathVariable("bookingId")Long bookingId,@RequestBody Bookings bookings1){
        return new ResponseEntity<>(bookingServiceImpl.updateBooking(bookingId,bookings1), HttpStatus.ACCEPTED);

    }

    /*@PutMapping("/bookings/{bookingId}")
    public ResponseEntity<Bookings> updateSeats(@PathVariable("bookingId")Long bookingId,@RequestBody Bookings updtBookings){

        return new ResponseEntity<>(bookingServiceImpl.updateSeats(bookingId,updtBookings), HttpStatus.ACCEPTED);

    }*/


    @ExceptionHandler
    public ResponseEntity<?> respondWithError(Exception e){
        return new ResponseEntity<>("Exception Occurred. More Info :"
                + e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
