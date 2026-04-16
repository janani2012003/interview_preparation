package com.example.super_market_billing_system.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.super_market_billing_system.Entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}

