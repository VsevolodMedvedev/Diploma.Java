package com.example.Diploma.v_1.models;

import com.example.Diploma.v_1.entities.EventEntity;
import com.example.Diploma.v_1.entities.TaskEntity;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Integer id;
    private String title;
    private String information;

    private Integer employeeId;

    public static Event toModel(EventEntity entity){
        Event model = new Event();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setInformation(entity.getInformation());
        model.setEmployeeId(entity.getEmployeeId());
        return model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

  }
