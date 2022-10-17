package com.example.Diploma.v_1.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "This date can't be empty")
    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @NotEmpty(message = "This boolean type can't be empty")
    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @NotEmpty(message = "Title can't be empty")
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "Info can't be empty")
    @Column(name = "information", nullable = false)
    private String information;

    @NotEmpty(message = "Employees_id can't be empty")
    @Column(name = "employees_id", nullable = false)
    private Integer employeeId;

    public TaskEntity(Boolean completed, String title, String information) {
        this.completed = completed;
        this.title = title;
        this.information = information;
    }
}
