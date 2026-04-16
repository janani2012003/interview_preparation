package com.example.hotel_room_booking_system.Service;

import com.example.hotel_room_booking_system.Entity.Customer;
import com.example.hotel_room_booking_system.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public Customer save(Customer c){
        return customerRepository.save(c);
    }
    public Customer update(int id,Customer c){
        Customer existing= customerRepository.findById(id).orElse(null);
        if(existing!=null){
            existing.setName(c.getName());
            existing.setPhone(c.getPhone());
            return customerRepository.save(existing);
        }
        return null;
    }
    public void delete(int id){
        customerRepository.deleteById(id);
    }
}
