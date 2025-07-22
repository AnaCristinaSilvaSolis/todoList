package com.todoList.service.Impl;

import com.todoList.dto.TaskDTO;
import com.todoList.entity.Task;
import com.todoList.repository.TaskRepository;
import com.todoList.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<TaskDTO> findAll() {

        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDTO> findById(Long id) {
        return taskRepository.findById(id).map(task -> modelMapper.map(task, TaskDTO.class));
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = modelMapper.map(taskDTO, Task.class);
        Task saveTask = taskRepository.save(task);

        return modelMapper.map(saveTask, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Long id) {

        Task taskCurret = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada " + id));

        taskDTO.setId(taskCurret.getId());

        modelMapper.map(taskDTO, taskCurret);

        Task taskUpdated = taskRepository.save(taskCurret);

        return modelMapper.map(taskUpdated, TaskDTO.class);
    }

    @Override
    public String deleteTask(Long id) {

        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()){
            taskRepository.deleteById(id);
            return "Tarea eliminada correctamente.";
        }else{
            return "La tarea con id: " + id + " no fue encontrada";
        }

    }
}
