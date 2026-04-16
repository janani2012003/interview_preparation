package com.example.super_market_billing_system.Controller;

import com.example.super_market_billing_system.Entity.Product;
import com.example.super_market_billing_system.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")


public class ProductController {
    @Autowired
    private ProductService productservice;
    @GetMapping("/billing")
    public List<Product> getAll(){
        return productservice.getAll();
    }
    @PostMapping("/addproduct")
    public Product add(@RequestBody Product p){
        return productservice.save(p);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product p){
        return productservice.updateAll(id,p);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        productservice.delete(id);
        return "Product deleted successfully";
    }

}




