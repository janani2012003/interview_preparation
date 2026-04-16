package com.example.hotel_room_booking_system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="date")
    private String date;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Room room;
}
