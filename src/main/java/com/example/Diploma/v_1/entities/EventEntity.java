package com.example.Diploma.v_1.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "Employees_id can't be empty")
    @Column(name = "employees_id", nullable = false)
    private Integer employeeId;

    @Column(name = "begin_Date")
    private LocalDateTime beginDate;

    @NotEmpty(message = "Title can't be empty")
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "Info can't be empty")
    @Column(name = "information", nullable = false)
    private String information;

    public EventEntity(String title, String information) {
        this.title = title;
        this.information = information;
    }
}
