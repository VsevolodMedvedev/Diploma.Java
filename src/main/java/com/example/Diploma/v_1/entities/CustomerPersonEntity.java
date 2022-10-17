package com.example.Diploma.v_1.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customerPerson")
public class CustomerPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "Customer_name can't be empty")
    @Column(name = "customers_id", nullable = false)
    private Integer customerId;

    @NotEmpty(message = "Employees_id can't be empty")
    @Column(name = "employees_id", nullable = false)
    private Integer employeeId;

    @NotEmpty(message = "Last name can't be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "First name can't be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Second name can't be empty")
    @Column(name = "second_name", nullable = false)
    private String secondName;

    @NotEmpty(message = "Post can't be empty")
    @Column(name = "post", nullable = false)
    private String post;

    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Phone can't be empty")
    @Column(name = "phone")
    private String phone;


    public CustomerPersonEntity(String lastName, String firstName,
                                String secondName, String post,
                                String email, String phone){
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.post = post;
        this.email = email;
        this.phone = phone;
    }
}
