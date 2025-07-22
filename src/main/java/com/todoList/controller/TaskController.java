package com.todoList.controller;

import com.todoList.dto.TaskDTO;
import com.todoList.entity.Task;
import com.todoList.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;

    /**
     * Listar todas las tareas
     * @return una lista con las tareas
     */
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> findAll(){
        return  new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    /**
     * Listar tareas por ID
     * @param id
     * @return tarea por ID
     */
    @GetMapping("/task/{id}")
    public ResponseEntity<Optional<TaskDTO>> findById(@PathVariable Long id){

        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    /**
     * Crear las tareas
     * @param taskDTO
     * @return tarea creada
     */
    @PostMapping("/task/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        return new ResponseEntity<>(taskService.createTask(taskDTO), HttpStatus.CREATED);
    }

    /**
     * Actualizar tareas por ID
     * @param taskDTO
     * @param id
     * @return Tarea actualizada
     */
    @PutMapping("/task/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable Long id){
        return new ResponseEntity<>(taskService.updateTask(taskDTO, id), HttpStatus.OK);
    }

    /**
     * Eliminar tareas
     * @param id
     * @return nada
     */
    @DeleteMapping("/task/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.NO_CONTENT);
    }


}
