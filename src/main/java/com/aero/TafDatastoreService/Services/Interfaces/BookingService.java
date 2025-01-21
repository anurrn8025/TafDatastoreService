package com.aero.TafDatastoreService.Services.Interfaces;
import com.aero.TafDatastoreService.Models.Bookings;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface BookingService {
    List<Bookings> getAllBookingsOfUser(Long userId);
    Bookings getSingleBooking(Long bookingId);
    Bookings AddBooking(Bookings bookings);
    Bookings updateBooking(Long bookingId, Bookings bookings1);

}
