package com.example.taska.service.impl;

import com.example.taska.domain.User;
import com.example.taska.dto.UserDTO;
import com.example.taska.repository.UserRepository;
import com.example.taska.service.UserService;
import com.example.taska.service.WebTokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebTokenService tokenService;

    @Override
    public void save(User user) {

        user.getTasks().forEach(t -> t.setUser(user));

       userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public String generateToken(User user) {
        return tokenService.generate(user);
    }

    @Override
    public boolean validateToken(String token) {

        Claims claims = tokenService.validate(token);

        String name = String.valueOf(claims.get("name"));
        String password = String.valueOf(claims.get("password"));

        return userRepository.existsByNameAndPassword(name, password);
    }

    @Override
    public boolean existUserWithGivenEmailAndPassword(UserDTO userDTO) {
        return userRepository.existsByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
    }
}
