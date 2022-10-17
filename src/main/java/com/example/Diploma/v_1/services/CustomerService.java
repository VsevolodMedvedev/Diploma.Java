package com.example.Diploma.v_1.services;

import com.example.Diploma.v_1.entities.CustomerEntity;
import com.example.Diploma.v_1.exceptions.CustomerExistException;
import com.example.Diploma.v_1.exceptions.CustomerNotFoundException;
import com.example.Diploma.v_1.exceptions.EmployeeNotFoundException;
import com.example.Diploma.v_1.models.Customer;
import com.example.Diploma.v_1.repositories.CustomerRepository;
import com.example.Diploma.v_1.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

   public CustomerEntity createCustomer (Customer customer) throws  CustomerExistException, EmployeeNotFoundException{
       var employee = employeeRepository.findById((customer.getEmployeeId()));
       if (employee.isEmpty())
           throw new EmployeeNotFoundException("Сотрудник не найден");

       if (customer.getId() != null && customer.getId() != 0)
           if (customerRepository.findById(customer.getId()).isEmpty())
               throw new CustomerExistException("Заказчик не существует");

       var entity = CustomerEntity.builder()
               .name(customer.getName())
               .address(customer.getAddress())
               .email(customer.getEmail())
               .phone(customer.getPhone())
               .employeeId(customer.getEmployeeId())
               .build();
       return customerRepository.save(entity);
   }

    public Customer getOne(Integer id) throws CustomerNotFoundException {
        CustomerEntity customer = customerRepository.findById(id).get();
        if(customer == null) {
            throw new CustomerNotFoundException("Заказчик не найден");
        }
        return Customer.toModel(customer);
    }

    public String delete (Integer id) {
        CustomerEntity customer = customerRepository.findById(id).get();
        String name = customer.getName();
        customerRepository.deleteById(id);
        return "Удален заказчик " + name;
    }
}
