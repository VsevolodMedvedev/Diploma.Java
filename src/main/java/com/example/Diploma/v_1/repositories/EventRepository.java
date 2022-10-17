package com.example.Diploma.v_1.repositories;

import com.example.Diploma.v_1.entities.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Integer> {
}
