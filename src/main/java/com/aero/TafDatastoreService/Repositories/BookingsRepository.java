package com.aero.TafDatastoreService.Repositories;

import com.aero.TafDatastoreService.Models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    //@Query("SELECT b FROM Bookings b WHERE b.user_id= :userId")
    //List<Bookings> findByUsersId(@Param("userId") Long userId);
    public List<Bookings> findByUsers_Id(Long userId);
}
