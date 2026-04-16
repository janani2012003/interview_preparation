package com.example.hotel_room_booking_system.Repository;

import com.example.hotel_room_booking_system.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
