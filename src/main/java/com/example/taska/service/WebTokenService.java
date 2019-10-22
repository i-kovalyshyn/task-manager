package com.example.taska.service;

import com.example.taska.domain.User;
import io.jsonwebtoken.Claims;

public interface WebTokenService {
    Claims validate(String token);
    String generate(User user);
}
