package com.example.Diploma.v_1.services;

import com.example.Diploma.v_1.entities.CustomerEntity;
import com.example.Diploma.v_1.entities.CustomerPersonEntity;
import com.example.Diploma.v_1.entities.EmployeeEntity;
import com.example.Diploma.v_1.exceptions.*;
import com.example.Diploma.v_1.models.Customer;
import com.example.Diploma.v_1.models.CustomerPerson;
import com.example.Diploma.v_1.repositories.CustomerPersonRepository;
import com.example.Diploma.v_1.repositories.CustomerRepository;
import com.example.Diploma.v_1.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerPersonService {
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private CustomerPersonRepository customerPersonRepository;

    @Autowired
    public CustomerPersonService(EmployeeRepository employeeRepository, CustomerRepository customerRepository, CustomerPersonRepository customerPersonRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.customerPersonRepository = customerPersonRepository;
    }
    public CustomerPersonEntity createCustomerPerson (CustomerPerson person) throws EmployeeNotFoundException, CustomerPersonExistException, CustomerNotFoundException {
        var employee = employeeRepository.findById((person.getEmployeeId()));
        var customer = customerRepository.findById((person.getCustomerId()));
        if (employee.isEmpty())
            throw new EmployeeNotFoundException("Сотрудник не найден");
        if (customer.isEmpty())
            throw new CustomerNotFoundException("Заказчик не найден");


        if (person.getId() != null && person.getId() != 0)
            if (customerPersonRepository.findById(person.getId()).isEmpty())
                throw new CustomerPersonExistException("Клиент с таким именем существует");

        var entity = CustomerPersonEntity.builder()
                .lastName(person.getLastName())
                .firstName(person.getFirstName())
                .secondName(person.getSecondName())
                .post(person.getPost())
                .email(person.getEmail())
                .phone(person.getPhone())
                .employeeId(person.getEmployeeId())
                .customerId(person.getCustomerId())
                .build();
        return customerPersonRepository.save(entity);
    }

    public CustomerPerson getOne(Integer id) throws CustomerPersonNotFoundException {
        CustomerPersonEntity customerPerson = customerPersonRepository.findById(id).get();
        if(customerPerson == null) {
            throw new CustomerPersonNotFoundException("Сотрудник не найден");
        }
        return CustomerPerson.toModel(customerPerson);
    }

    public String delete (Integer id) {
        CustomerPersonEntity person = customerPersonRepository.findById(id).get();
        String name = person.getLastName() + " " + person.getFirstName() + " "
                + person.getSecondName();
        customerRepository.deleteById(id);
        return "Удален пользователь " + name;
    }

}
