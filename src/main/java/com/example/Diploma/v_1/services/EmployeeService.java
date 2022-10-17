package com.example.Diploma.v_1.services;

import com.example.Diploma.v_1.exceptions.EmployeeExistException;
import com.example.Diploma.v_1.exceptions.EmployeeNotFoundException;
import com.example.Diploma.v_1.entities.EmployeeEntity;
import com.example.Diploma.v_1.models.Employee;
import com.example.Diploma.v_1.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

   private EmployeeRepository employeeRepository;

   @Autowired
   public EmployeeService(EmployeeRepository employeeRepository) {
      this.employeeRepository = employeeRepository;
   }

   public EmployeeEntity registration (EmployeeEntity employee) throws EmployeeExistException {
      if(employeeRepository.findByLastName(employee.getLastName()) != null){
         throw new EmployeeExistException("Сотрудник с таким именем существует");
      }
      return employeeRepository.save(employee);
   }

   public Employee getOne(Integer id) throws EmployeeNotFoundException {
      Optional<EmployeeEntity> employee = employeeRepository.findById(id);
      if(employee.isEmpty()) {
         throw new EmployeeNotFoundException("Сотрудник не найден");
      }
      return Employee.toModel(employee.get());
   }

   public String delete (Integer id) {
      employeeRepository.deleteById(id);
      return "Удален сотрудник с id = " + id;
   }
}

