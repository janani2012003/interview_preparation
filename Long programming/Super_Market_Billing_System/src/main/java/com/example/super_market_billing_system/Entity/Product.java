package com.example.super_market_billing_system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    @Column(name="product_name")
    private String name;
    @Column(name ="product_price")
    private double price;
    @Column(name ="product_quality")
    private int quality;
}
