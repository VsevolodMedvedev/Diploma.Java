package com.example.Diploma.v_1.controllers;

import com.example.Diploma.v_1.exceptions.EmployeeExistException;
import com.example.Diploma.v_1.exceptions.EmployeeNotFoundException;
import com.example.Diploma.v_1.entities.EmployeeEntity;
import com.example.Diploma.v_1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody EmployeeEntity employee){
        try {
            employeeService.registration(employee);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        } catch (EmployeeExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneEmployee(@RequestParam Integer id){
        try {
            return ResponseEntity.ok(employeeService.getOne(id));
        } catch (EmployeeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(employeeService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }



}