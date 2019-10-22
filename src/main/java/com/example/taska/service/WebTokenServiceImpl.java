package com.example.taska.service;

import com.example.taska.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WebTokenServiceImpl implements WebTokenService {
    public static final String KEY_WORD = "secret_task";
    public static final int JWT_TOKEN_EXPIRATION = 5 * 60 * 60;

    @Override
    public Claims validate(String token) {
        return Jwts.parser().setSigningKey(KEY_WORD).parseClaimsJws(token).getBody();
    }

    @Override
    public String generate(User user) {

        Map<String, Object> map = new HashMap<>();

        map.put("name", user.getName());
        map.put("password", user.getPassword());

        return Jwts.builder()
                .setClaims(map)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS256, KEY_WORD).compact();
    }
}
