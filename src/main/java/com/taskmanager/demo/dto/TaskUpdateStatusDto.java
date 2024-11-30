package com.taskmanager.demo.dto;

import com.taskmanager.demo.database.entity.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class TaskUpdateStatusDto {

    @NotNull(message = "Task ID cannot be null")
    Long taskId;

    @NotNull(message = "Status cannot be null")
    Status status;
}
