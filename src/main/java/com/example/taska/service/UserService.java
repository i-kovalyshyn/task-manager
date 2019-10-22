package com.example.taska.service;

import com.example.taska.domain.User;

public interface UserService extends CRUDService<User> {
    String generateToken(User user);

    boolean validateToken(String token);
}
