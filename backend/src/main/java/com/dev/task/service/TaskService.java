package com.dev.task.service;

import com.dev.task.domain.CreateTaskRequest;
import com.dev.task.domain.UpdateTaskRequest;
import com.dev.task.domain.entity.Task;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}