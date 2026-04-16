package com.example.super_market_billing_system.Service;

import com.example.super_market_billing_system.Entity.Customer;
import com.example.super_market_billing_system.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Customerservice {
    @Autowired
    private CustomerRepository customerRepositoryepo;

    public List<Customer> getAll() {
        return customerRepositoryepo.findAll();
    }

    public Customer save(Customer c) {
        return customerRepositoryepo.save(c);

    }

    public Customer updateAll(int id, Customer c) {
        Customer existing = customerRepositoryepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(c.getName());
            return customerRepositoryepo.save(existing);
        } else {
            return null;
        }
    }

    public void delete(int id) {
        customerRepositoryepo.deleteById(id);
    }
}
