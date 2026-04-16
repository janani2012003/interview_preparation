package com.example.super_market_billing_system.Controller;

import com.example.super_market_billing_system.Entity.Bill;
import com.example.super_market_billing_system.Service.Billservice;
//import com.example.super_market_billing_system.Service.billservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")


public class BillController {
    @Autowired
    private Billservice billservice;
    @GetMapping("/billing")
    public List<Bill> getAll(){
        return billservice.getAll();
    }
    @PostMapping("/addbill")
    public Bill addBill(@RequestBody Bill b){

        return billservice.save(b);
    }
    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable int id ,@RequestBody Bill b){

        return billservice.update(id,b);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        billservice.delete(id);
        return "Bill deleted successfully";
    }

}





