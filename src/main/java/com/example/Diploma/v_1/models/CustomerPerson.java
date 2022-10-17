package com.example.Diploma.v_1.models;


import com.example.Diploma.v_1.entities.CustomerPersonEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPerson {
    private Integer id;
    private String lastName;
    private String firstName;
    private String secondName;
    private String post;
    private String email;
    private String phone;
    private Integer employeeId;
    private Integer customerId;



    public static CustomerPerson toModel(CustomerPersonEntity entity) {
        CustomerPerson model = new CustomerPerson();
        model.setId(entity.getId());
        model.setLastName(entity.getLastName());
        model.setFirstName(entity.getFirstName());
        model.setSecondName(entity.getSecondName());
        model.setPost(entity.getPost());
        model.setEmail(entity.getEmail());
        model.setPhone(entity.getPhone());
        model.setEmployeeId(entity.getEmployeeId());
        model.setCustomerId(entity.getCustomerId());
        return model;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

