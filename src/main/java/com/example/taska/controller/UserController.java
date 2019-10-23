package com.example.taska.controller;

import com.example.taska.domain.User;
import com.example.taska.dto.TaskDTO;
import com.example.taska.service.TaskService;
import com.example.taska.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("user")
@SessionAttributes("jwt_token")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping(value = "/register")
    @ModelAttribute("jwt_token")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.save(user);
        String token = userService.generateToken(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@SessionAttribute("jwt_token") ResponseEntity<String> token) {

        ResponseEntity<String> responseEntity = new ResponseEntity<>("Register, please", HttpStatus.FORBIDDEN);

        if (userService.validateToken(token.getBody())) {
            responseEntity = new ResponseEntity<>("Hello", HttpStatus.OK);
        }

        return responseEntity;
    }
/*
    @PostMapping(value = "/login")
    public ResponseEntity<String> login2(@SessionAttribute("jwt_token") String token) {


        if (userService.validateToken(token)) {
            return new ResponseEntity<>("Hello", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Register, please", HttpStatus.FORBIDDEN);
        }

    }*/


    @PutMapping(value = "/share/task")
    public void shareTask(@RequestBody TaskDTO taskDTO) {
        taskService.share(taskDTO);
    }

    @DeleteMapping("/delete/{id}")//delete/3
    public void deleteById(@PathVariable(value = "id") int id) {
        userService.deleteById(id);
    }

}


