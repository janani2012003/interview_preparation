package com.example.super_market_billing_system.Controller;

import com.example.super_market_billing_system.Entity.Customer;
import com.example.super_market_billing_system.Service.Customerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")


public class CustomerController {
    @Autowired
    private Customerservice repo;
    @GetMapping("/billing")
    public List<Customer> getAll(){
        return repo.getAll();
    }
    @PostMapping("/addcustomer")
    public Customer add(@RequestBody Customer c){

        return repo.save(c);
    }
    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer c){

        return repo.updateAll(id,c);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repo.delete(id);
        return "Customer deleted successfully";
    }

}

