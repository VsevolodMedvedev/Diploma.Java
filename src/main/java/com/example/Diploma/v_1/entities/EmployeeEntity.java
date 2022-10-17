package com.example.Diploma.v_1.entities;

import lombok.*;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@ToString(exclude = "customers")
@Entity
@Table(name = "employees")

public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //@NotEmpty(message = "Last name can't be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "First name can't be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Second name can't be empty")
    @Column(name = "second_name", nullable = false)
    private String secondName;

    @NotEmpty(message = "Date of birth can't be empty")
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth; // подходит ли такой формат данных для отображения в бд?

    @NotEmpty(message = "Post can't be empty")
    @Column(name = "post", nullable = false)
    private String post;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

  /*  @Column(name = "check")
    private Boolean check;
    */

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employees_id")
    //FetchType.Lazy говорит, что не нужно нам подгружать весь список сотрудников если это не указанно в запросе
    private List<CustomerEntity> customers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employees_id")
    private List<TaskEntity> tasks;

    public EmployeeEntity(String lastName, String firstName, String secondName,Date dateOfBirth,
                          String post, String email, String phone, String password/*, Boolean check*/) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.post = post;
        this.email = email;
        this.phone = phone;
      //  this.check = check;
        this.password = password;
    }


    public List<CustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerEntity> customers) {
        this.customers = customers;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }
    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }


}
