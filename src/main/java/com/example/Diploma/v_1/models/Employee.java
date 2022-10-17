package com.example.Diploma.v_1.models;

import com.example.Diploma.v_1.entities.CustomerEntity;
import com.example.Diploma.v_1.entities.EmployeeEntity;
import com.example.Diploma.v_1.entities.TaskEntity;

import java.util.Date;
import java.util.List;

public class Employee {
    private Integer id;
    private String lastName;
    private String firstName;
    private String secondName;
    private Date dateOfBirth;
    private String post;
    private String email;
    private String phone;

    private String password;

   // private Boolean check;


    private List<TaskEntity> tasks;
    private List<CustomerEntity> customers;



    public static Employee toModel(EmployeeEntity entity) {
        Employee model = new Employee();
        model.setId(entity.getId());
        model.setLastName(entity.getLastName());
        model.setFirstName(entity.getFirstName());
        model.setSecondName(entity.getSecondName());
        model.setDateOfBirth(entity.getDateOfBirth());
        model.setPost(entity.getPost());
        model.setEmail(entity.getEmail());
        model.setPhone(entity.getPhone());
        model.setTasks(entity.getTasks());
        model.setCustomers(entity.getCustomers());
        return model;
    }

    public Employee() {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

 /*  public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
*/
    public void setPassword(String password) {
        this.password = password;
    }

    public List<CustomerEntity> getCustomers() {
        return customers;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }
    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public void setCustomers(List<CustomerEntity> customers) {
        this.customers = customers;
    }


}
