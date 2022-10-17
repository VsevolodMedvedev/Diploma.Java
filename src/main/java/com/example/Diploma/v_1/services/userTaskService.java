package com.example.Diploma.v_1.services;

import com.example.Diploma.v_1.entities.TaskEntity;
import com.example.Diploma.v_1.exceptions.TaskNotFoundException;
import com.example.Diploma.v_1.models.Task;
import com.example.Diploma.v_1.repositories.EmployeeRepository;
import com.example.Diploma.v_1.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userTaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

   /* public Task getAll(Integer id) throws TaskNotFoundException {
        List<Task> tasks = taskRepository.findAllById();
        if(tasks == null) {
            throw new TaskNotFoundException("Задачи не найдены");
        }
        return Task.toModel(task);
    } */
}
