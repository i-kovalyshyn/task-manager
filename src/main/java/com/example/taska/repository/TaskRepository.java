package com.example.taska.repository;


import com.example.taska.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {

/*    @Modifying
    @Query(value = "update Task t set t.user =: userT where t.id = :taskId) )
            void shareTask(@Param("userT") User user, @Param("taskId") int id);*/


}
