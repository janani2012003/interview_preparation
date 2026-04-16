package com.example.hotel_room_booking_system.controller;


import com.example.hotel_room_booking_system.Entity.Room;

import com.example.hotel_room_booking_system.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository repo;
    @GetMapping
    public List<Room> getAll(){
        return repo.findAll();
    }
    @PostMapping
    public Room add(@RequestBody Room r){

        return repo.save(r);
    }
    @PutMapping("/{id}")
    public Room update(@PathVariable int id,@RequestBody Room r){
        return repo.save(r);

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        repo.deleteById(id);
        return "Room deleted";
    }
}

