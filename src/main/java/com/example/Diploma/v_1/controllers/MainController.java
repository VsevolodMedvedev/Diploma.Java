package com.example.Diploma.v_1.controllers;


import com.example.Diploma.v_1.entities.TaskEntity;
import com.example.Diploma.v_1.models.Task;
import com.example.Diploma.v_1.services.EmployeeService;
import com.example.Diploma.v_1.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

}




  /*
    @GetMapping
    public String employees(@RequestParam(name = "last_name", required = false) String title, Model model) {
        model.addAttribute("employees", employeeService.listEmployees(title));
        return "employees";
    }

  @GetMapping("/product/{id}")
    public String employeeInfo(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee-info";
    } */
/*
    @PostMapping("/employee/create")
    public String createEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

   **** refresh

*/

