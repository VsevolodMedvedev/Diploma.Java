package com.example.Diploma.v_1.repositories;

import com.example.Diploma.v_1.entities.EmployeeEntity;
import com.example.Diploma.v_1.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer>{
    TaskRepository findByTitle(String title);
}

