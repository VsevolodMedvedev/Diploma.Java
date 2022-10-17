package com.example.Diploma.v_1.repositories;

import com.example.Diploma.v_1.entities.CustomerPersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPersonRepository extends CrudRepository<CustomerPersonEntity, Integer> {

}