package com.example.super_market_billing_system.Service;

import com.example.super_market_billing_system.Entity.Product;
import com.example.super_market_billing_system.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    @Autowired
    private productRepository productRepository;
    public List<Product> getAll(){

        return productRepository.findAll();
    }
    public Product save(Product p){
        return productRepository.save(p);

    }

    public Product updateAll(int id, Product p) {
        Product existing = productRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(p.getName());
            existing.setPrice(p.getPrice());
            existing.setQuality(p.getQuality());

            return productRepository.save(existing);
        } else {
            return null;
        }
    }
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
