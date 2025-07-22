package com.todoList.service;

import com.todoList.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<TaskDTO> findAll();
    Optional<TaskDTO> findById(Long id);
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(TaskDTO taskDTO, Long id);
    String deleteTask (Long id);
}
