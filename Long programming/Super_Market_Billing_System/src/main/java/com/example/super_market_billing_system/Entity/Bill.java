package com.example.super_market_billing_system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="total")
    private double total;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer_id;
}
