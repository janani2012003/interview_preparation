package com.example.hotel_room_booking_system.Service;

import com.example.hotel_room_booking_system.Entity.Customer;
import com.example.hotel_room_booking_system.Entity.Room;
import com.example.hotel_room_booking_system.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public List<Room> getAll(){
        return roomRepository.findAll();
    }
    public Room save(Room r){
        return roomRepository.save(r);
    }
    public Room update(int id,Room r){
        Room existing= roomRepository.findById(id).orElse(null);
        if(existing!=null){
            existing.setType(r.getType());
            return roomRepository.save(existing);
        }
        return null;
    }
    public void delete(int id){
        roomRepository.deleteById(id);
    }
}
