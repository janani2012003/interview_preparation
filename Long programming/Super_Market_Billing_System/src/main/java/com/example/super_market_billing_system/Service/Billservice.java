package com.example.super_market_billing_system.Service;

import com.example.super_market_billing_system.Entity.Bill;
import com.example.super_market_billing_system.Repository.BillRepository;
//import com.example.super_market_billing_system.Repository.billRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Billservice {
    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill save(Bill b) {
        return billRepository.save(b);

    }

    public Bill update(int id, Bill b) {
        Bill existing = billRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTotal(b.getTotal());
            return billRepository.save(existing);

        } else {
            return null;
        }
    }

    public void delete(int id) {
        billRepository.deleteById(id);
    }
}


