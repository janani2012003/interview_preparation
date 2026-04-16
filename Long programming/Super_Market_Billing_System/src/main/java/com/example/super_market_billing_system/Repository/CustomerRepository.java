package com.example.super_market_billing_system.Repository;

import com.example.super_market_billing_system.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}