package com.example.taska.controller;

import com.example.taska.domain.User;
import com.example.taska.dto.TaskDTO;
import com.example.taska.dto.UserDTO;
import com.example.taska.service.TaskService;
import com.example.taska.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User user) {
        userService.save(user);
        return userService.generateToken(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, HttpServletRequest request) {

        ResponseEntity<String> responseEntity = new ResponseEntity<>("Register, please", HttpStatus.FORBIDDEN);

        String jwtToken = request.getHeader("Authorization").replaceAll("Bearer ", "");

        if (userService.validateToken(jwtToken) && userService.existUserWithGivenEmailAndPassword(userDTO)) {
            responseEntity = new ResponseEntity<>("Hello", HttpStatus.OK);
        }

        return responseEntity;
    }


    @PutMapping(value = "/share/task")
    public void shareTask(@RequestBody TaskDTO taskDTO) {
        taskService.share(taskDTO);
    }

    @DeleteMapping("/delete/{id}")//delete/3
    public void deleteById(@PathVariable(value = "id") int id) {
        userService.deleteById(id);
    }

}


