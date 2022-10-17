package com.example.Diploma.v_1.repositories;

import com.example.Diploma.v_1.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
        EmployeeEntity findByLastName(String lastName);
}

