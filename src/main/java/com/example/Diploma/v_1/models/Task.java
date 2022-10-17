package com.example.Diploma.v_1.models;

import com.example.Diploma.v_1.entities.TaskEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Integer id;
    private String title;
    private String information;
    private Boolean completed;

    private Integer employeeId;

    public static Task toModel(TaskEntity entity){
        Task model = new Task();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setInformation(entity.getInformation());
        model.setCompleted(entity.getCompleted());
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
