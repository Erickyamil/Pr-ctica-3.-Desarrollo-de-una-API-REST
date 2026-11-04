package com.dev.task.mapper;

import com.dev.task.domain.CreateTaskRequest;
import com.dev.task.domain.UpdateTaskRequest;
import com.dev.task.domain.dto.CreateTaskRequestDTO;
import com.dev.task.domain.dto.TaskDTO;
import com.dev.task.domain.dto.UpdateTaskRequestDTO;
import com.dev.task.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDTO(CreateTaskRequestDTO dto);

    UpdateTaskRequest fromDTO(UpdateTaskRequestDTO dto);

    TaskDTO toDTO(Task task);
}
