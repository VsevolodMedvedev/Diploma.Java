package com.example.Diploma.v_1.services;

import com.example.Diploma.v_1.entities.EventEntity;
import com.example.Diploma.v_1.entities.TaskEntity;
import com.example.Diploma.v_1.exceptions.EmployeeNotFoundException;
import com.example.Diploma.v_1.exceptions.TaskExistException;
import com.example.Diploma.v_1.exceptions.TaskNotFoundException;
import com.example.Diploma.v_1.models.Task;
import com.example.Diploma.v_1.repositories.EmployeeRepository;
import com.example.Diploma.v_1.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<TaskEntity> getAll() {
        return (List<TaskEntity>) taskRepository.findAll();
    }

    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }


    public TaskEntity createTask (Task task) throws TaskExistException, EmployeeNotFoundException {
        var employee = employeeRepository.findById(task.getEmployeeId());

        if (employee.isEmpty())
            throw new EmployeeNotFoundException("Пользователь не найден");

        if (task.getId() != null && task.getId() != 0)
            if (taskRepository.findById(task.getId()).isEmpty())
                throw new TaskExistException("Пользователь с таким именем существует");

        var entity = TaskEntity.builder()
                .title(task.getTitle())
                .completed(task.getCompleted())
                .information(task.getInformation())
                .employeeId(task.getEmployeeId())
                .build();

        return taskRepository.save(entity);
    }
    public TaskEntity complete (Integer id) {
        TaskEntity task = taskRepository.findById(id).get();
        task.setCompleted(!task.getCompleted());
        return taskRepository.save(task);
    }
    public Task getOne(Integer id) throws TaskNotFoundException {
        TaskEntity task = taskRepository.findById(id).get();
        if(task == null) {
            throw new TaskNotFoundException("Сотрудник не найден");
        }
        return Task.toModel(task);
    }

    public String delete(Integer id) {
        TaskEntity task = taskRepository.findById(id).get();
        String title = task.getTitle();
        taskRepository.deleteById(id);
        return "Удалена задача " + title;
    }
}
