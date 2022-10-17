package com.example.Diploma.v_1.models;

import com.example.Diploma.v_1.entities.CustomerEntity;
import com.example.Diploma.v_1.entities.CustomerPersonEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;

    private Integer employeeId;

    private List<CustomerPersonEntity> persons;

    public static Customer toModel(CustomerEntity entity) {
        Customer model = new Customer();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setAddress(entity.getAddress());
        model.setEmail(entity.getEmail());
        model.setPhone(entity.getPhone());
        model.setEmployeeId(entity.getEmployeeId());
        model.setPersons(entity.getPerson());
        return model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CustomerPersonEntity> getPersons() {
        return persons;
    }

    public void setPersons(List<CustomerPersonEntity> persons) {
        this.persons = persons;
    }
}
