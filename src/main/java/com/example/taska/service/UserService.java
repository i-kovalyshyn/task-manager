package com.example.taska.service;

import com.example.taska.domain.User;
import com.example.taska.dto.UserDTO;

public interface UserService extends CRUDService<User> {
    String generateToken(User user);

    boolean validateToken(String token);

    boolean existUserWithGivenEmailAndPassword(UserDTO userDTO);
}
