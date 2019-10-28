package com.example.taska.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
public class UserDTO {

    @Email
    private String email;
    private String password;
}
