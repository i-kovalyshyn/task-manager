package com.example.taska.repository;


import com.example.taska.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
