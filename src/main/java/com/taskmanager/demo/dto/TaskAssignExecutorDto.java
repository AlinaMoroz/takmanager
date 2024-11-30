package com.taskmanager.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class TaskAssignExecutorDto {

    @NotNull(message = "Task ID cannot be null")
    Long taskId;

    @NotNull(message = "Executor ID cannot be null")
    Long executorId;
}
