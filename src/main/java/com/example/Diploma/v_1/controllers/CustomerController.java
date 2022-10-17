package com.example.Diploma.v_1.controllers;

import com.example.Diploma.v_1.entities.CustomerEntity;
import com.example.Diploma.v_1.exceptions.CustomerNotFoundException;
import com.example.Diploma.v_1.models.Customer;
import com.example.Diploma.v_1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        try {
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneCustomer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(customerService.getOne(id));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(customerService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
