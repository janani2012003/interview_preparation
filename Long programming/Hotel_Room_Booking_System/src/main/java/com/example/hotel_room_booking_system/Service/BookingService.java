package com.example.hotel_room_booking_system.Service;

import com.example.hotel_room_booking_system.Entity.Booking;
import com.example.hotel_room_booking_system.Entity.Room;
import com.example.hotel_room_booking_system.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }
    public Booking save(Booking  b){
        return bookingRepository.save(b);
    }
    public Booking update(int id,Booking b){
        Booking existing= bookingRepository.findById(id).orElse(null);
        if(existing!=null){
            existing.setCustomer(b.getCustomer());
            existing.setRoom(b.getRoom());
            return bookingRepository.save(existing);
        }
        return null;
    }
    public void delete(int id){
        bookingRepository.deleteById(id);
    }
}

