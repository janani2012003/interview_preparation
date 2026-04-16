package com.example.hotel_room_booking_system.Repository;

import com.example.hotel_room_booking_system.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
