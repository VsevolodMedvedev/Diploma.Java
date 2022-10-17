package com.example.Diploma.v_1.entities;

import com.example.Diploma.v_1.models.CustomerPerson;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "This name can't be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @NotEmpty(message = "Employees_id can't be empty")
    @Column(name = "employees_id", nullable = false)
    private Integer employeeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_id")
    private List<CustomerPersonEntity> person;

    public CustomerEntity(String name, String address, String email, String phone){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public List<CustomerPersonEntity> getPerson() {
        return person;
    }
}
