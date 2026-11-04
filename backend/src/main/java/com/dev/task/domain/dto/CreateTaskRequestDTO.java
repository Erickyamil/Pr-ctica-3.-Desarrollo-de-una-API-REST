package com.dev.task.domain.dto;

import com.dev.task.domain.entity.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;

public record CreateTaskRequestDTO(
        @NotBlank(message = "Title must not be blank") @Length(max = 255, message = "Title must be up to 255 characters") String title,

        @Nullable @Length(max = 1000, message = "Description must be up to 1000 characters") String description,

        @Nullable @FutureOrPresent(message = "Due date must be in the future or present") LocalDate dueDate,

        @NotNull(message = "Priority must be provided") TaskPriority priority) {
}