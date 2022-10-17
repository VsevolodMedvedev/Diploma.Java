package com.example.Diploma.v_1.controllers;

import com.example.Diploma.v_1.entities.CustomerPersonEntity;
import com.example.Diploma.v_1.exceptions.CustomerPersonNotFoundException;
import com.example.Diploma.v_1.models.Customer;
import com.example.Diploma.v_1.models.CustomerPerson;
import com.example.Diploma.v_1.services.CustomerPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class CustomerPersonController {
    private final CustomerPersonService customerPersonService;

    public CustomerPersonController(CustomerPersonService customerPersonService) {
        this.customerPersonService = customerPersonService;
    }


    //Верно ли? 3 параметра!? см. CustomerPersonService
    @PostMapping
    public ResponseEntity createCustomerPerson(@RequestBody CustomerPerson person) {
        try {
           return ResponseEntity.ok(customerPersonService.createCustomerPerson(person));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneEmployee(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(customerPersonService.getOne(id));
        } catch (CustomerPersonNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(customerPersonService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
