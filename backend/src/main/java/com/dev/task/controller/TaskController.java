package com.dev.task.controller;

import com.dev.task.domain.CreateTaskRequest;
import com.dev.task.domain.UpdateTaskRequest;
import com.dev.task.domain.dto.CreateTaskRequestDTO;
import com.dev.task.domain.dto.TaskDTO;
import com.dev.task.domain.dto.UpdateTaskRequestDTO;
import com.dev.task.mapper.TaskMapper;
import com.dev.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody CreateTaskRequestDTO requestDTO) {
        CreateTaskRequest request = taskMapper.fromDTO(requestDTO);
        var task = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toDTO(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> listTasks() {
        List<TaskDTO> tasks = taskService.listTasks().stream()
                .map(taskMapper::toDTO)
                .toList();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDTO requestDTO) {
        UpdateTaskRequest request = taskMapper.fromDTO(requestDTO);
        var updatedTask = taskService.updateTask(taskId, request);
        return ResponseEntity.ok(taskMapper.toDTO(updatedTask));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}