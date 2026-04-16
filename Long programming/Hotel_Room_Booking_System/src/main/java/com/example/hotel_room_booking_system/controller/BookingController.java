package com.example.hotel_room_booking_system.controller;
import com.example.hotel_room_booking_system.Entity.Booking;
import com.example.hotel_room_booking_system.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class BookingController {
    @Autowired
    private BookingRepository repo;
    @GetMapping
    public List<Booking> getAll(){
        return repo.findAll();
    }
    @PostMapping
    public Booking add(@RequestBody Booking b){

        return repo.save(b);
    }
    @PutMapping("/{id}")
    public Booking update(@PathVariable int id,@RequestBody Booking b){
        return repo.save(b);

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        repo.deleteById(id);
        return "Booking deleted";
    }
}


