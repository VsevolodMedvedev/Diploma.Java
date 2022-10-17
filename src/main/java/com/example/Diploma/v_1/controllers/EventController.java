package com.example.Diploma.v_1.controllers;

import com.example.Diploma.v_1.entities.EventEntity;
import com.example.Diploma.v_1.exceptions.EventNotFoundException;
import com.example.Diploma.v_1.models.Event;
import com.example.Diploma.v_1.models.Task;
import com.example.Diploma.v_1.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;
    //создание
    @PostMapping
    public ResponseEntity createEvent(@RequestBody Event event) {
        try {
            return ResponseEntity.ok(eventService.createEvent(event));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneTask(@RequestParam Integer id){
        try {
            return ResponseEntity.ok(eventService.getOne(id));
        } catch (EventNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
