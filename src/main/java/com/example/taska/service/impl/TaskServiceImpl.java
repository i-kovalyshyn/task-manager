package com.example.taska.service.impl;

import com.example.taska.domain.Task;
import com.example.taska.domain.User;
import com.example.taska.dto.TaskDTO;
import com.example.taska.repository.TaskRepository;
import com.example.taska.repository.UserRepository;
import com.example.taska.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void share(TaskDTO taskDTO) {
        String email = taskDTO.getEmail();
        int taskId = taskDTO.getTaskId();

        User user = userRepository.findByEmail(email);
        Task task = taskRepository.findById(taskId).get();

        user.getTasks().add(task);

        userRepository.save(user);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
