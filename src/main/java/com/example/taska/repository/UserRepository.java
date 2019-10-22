package com.example.taska.repository;

import com.example.taska.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    boolean existsByNameAndPassword(String name, String password);
}
