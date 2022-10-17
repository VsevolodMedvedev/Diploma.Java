package com.example.Diploma.v_1.controllers;

import com.example.Diploma.v_1.entities.TaskEntity;
import com.example.Diploma.v_1.exceptions.TaskNotFoundException;
import com.example.Diploma.v_1.models.Task;
import com.example.Diploma.v_1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //создание
    @PostMapping
    public ResponseEntity createTask(@RequestBody Task task) {
        try {
            return ResponseEntity.ok(taskService.createTask(task));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity completeTask(@RequestBody TaskEntity task,
                                     @RequestParam Integer id) {
        try {
            return ResponseEntity.ok(taskService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneTask(@RequestParam Integer id){
        try {
            return ResponseEntity.ok(taskService.getOne(id));
        } catch (TaskNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/";
    }

}