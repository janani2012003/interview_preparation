package com.example.hotel_room_booking_system.Repository;

import com.example.hotel_room_booking_system.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}