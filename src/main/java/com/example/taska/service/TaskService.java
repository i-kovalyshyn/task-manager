package com.example.taska.service;

import com.example.taska.domain.Task;
import com.example.taska.dto.TaskDTO;

import java.util.List;

public interface TaskService extends CRUDService<Task> {
    void share(TaskDTO taskDTO);

    List<Task> getAll();
}
