package com.example.hotel_room_booking_system.controller;

import com.example.hotel_room_booking_system.Entity.Customer;
import com.example.hotel_room_booking_system.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repo;
    @GetMapping
    public List<Customer> getAll(){
        return repo.findAll();
    }
    @PostMapping
    public Customer add(@RequestBody Customer c){
        return repo.save(c);
    }
    @PutMapping("/{id}")
    public Customer update(@PathVariable int id,@RequestBody Customer c){
        return repo.save(c);

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        repo.deleteById(id);
        return "Customer deleted";
    }
}
