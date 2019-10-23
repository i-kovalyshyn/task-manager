package com.example.taska.repository;

import com.example.taska.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    boolean existsByNameAndPassword(String name, String password);

}
