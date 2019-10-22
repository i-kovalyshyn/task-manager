package com.example.taska.controller;

import com.example.taska.domain.Task;
import com.example.taska.service.CRUDService;
import com.example.taska.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Task task) {
        taskService.save(task);
    }

    @PutMapping("/update")
    public void update(Task task) {
        taskService.save(task);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        taskService.deleteById(id);
    }


    @GetMapping(value = "/list")
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

}
