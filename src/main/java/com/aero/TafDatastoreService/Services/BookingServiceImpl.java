package com.aero.TafDatastoreService.Services;

import com.aero.TafDatastoreService.Models.Bookings;
import com.aero.TafDatastoreService.Services.Interfaces.BookingService;
import org.springframework.http.ResponseEntity;
import com.aero.TafDatastoreService.Models.Flights;
import com.aero.TafDatastoreService.Repositories.BookingsRepository;
import com.aero.TafDatastoreService.Services.Interfaces.FlightService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingsRepository bookingsRepository;

    public BookingServiceImpl(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    @Override
    public List<Bookings> getAllBookingsOfUser(Long userId) {
        System.out.println("get all bookings of a specific user");
      // return bookingsRepository.findAllById(Collections.singleton(userId));
        return bookingsRepository.findByUsers_Id(userId);
    }

    @Override
    public Bookings getSingleBooking(Long bookingId) {
        System.out.println("get booking details for single bookingid ");

        return bookingsRepository.findById(bookingId).orElse(null);
    }

    @Override
    public Bookings AddBooking(Bookings bookings) {
        System.out.println("Add new booking");

        return bookingsRepository.save(bookings);
    }

    @Override
    public Bookings updateBooking(Long bookingId, Bookings bookings1) {
        System.out.println("Update existing booking details");
        System.out.println("bookingId is = "+ bookingId);

        Optional<Bookings> existingBooking = bookingsRepository.findById(bookingId);

        if (existingBooking.isPresent()) {
            Bookings upbook = existingBooking.get();
            upbook.setStatus(bookings1.getStatus());
            return bookingsRepository.save(upbook);

        }
        else{
            new RuntimeException("booking does not exists");
            return null;
        }

    }


}
