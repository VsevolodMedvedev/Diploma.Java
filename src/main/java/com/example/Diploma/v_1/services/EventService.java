package com.example.Diploma.v_1.services;

import com.example.Diploma.v_1.entities.CustomerEntity;
import com.example.Diploma.v_1.entities.EmployeeEntity;
import com.example.Diploma.v_1.entities.EventEntity;
import com.example.Diploma.v_1.entities.TaskEntity;
import com.example.Diploma.v_1.exceptions.*;
import com.example.Diploma.v_1.models.Event;
import com.example.Diploma.v_1.models.Task;
import com.example.Diploma.v_1.repositories.EmployeeRepository;
import com.example.Diploma.v_1.repositories.EventRepository;
import com.example.Diploma.v_1.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {
    private EventRepository eventRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EventService(EventRepository eventRepository, EmployeeRepository employeeRepository) {
        this.eventRepository = eventRepository;
        this.employeeRepository = employeeRepository;
    }

    public EventEntity createEvent (Event event) throws EventExistException, EmployeeNotFoundException {
        var employee = employeeRepository.findById(event.getEmployeeId());

        if (employee.isEmpty())
            throw new EmployeeNotFoundException("Пользователь не найден");

        if (event.getId() != null && event.getId() != 0)
            if (eventRepository.findById(event.getId()).isEmpty())
                throw new EventExistException("Событие уже существует");

        var entity = EventEntity.builder()
                .title(event.getTitle())
                .information(event.getInformation())
                .employeeId(event.getEmployeeId())
                .build();

        return eventRepository.save(entity);
    }
    public Event getOne(Integer id) throws EventNotFoundException {
        EventEntity event = eventRepository.findById(id).get();
        if(event == null) {
            throw new EventNotFoundException("Событие не найдено");
        }
        return Event.toModel(event);
    }
    public String delete(Integer id) {
        EventEntity event = eventRepository.findById(id).get();
        String title = event.getTitle();
        eventRepository.deleteById(id);
        return "Удалено событие " + title;
    }
}
