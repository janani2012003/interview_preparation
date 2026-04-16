package com.example.super_market_billing_system.Repository;

import com.example.super_market_billing_system.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Integer> {
}