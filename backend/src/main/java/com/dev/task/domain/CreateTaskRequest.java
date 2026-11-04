package com.dev.task.domain;

import com.dev.task.domain.entity.TaskPriority;
import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority) {
}