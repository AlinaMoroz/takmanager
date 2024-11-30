package com.taskmanager.demo.dto;

import com.taskmanager.demo.database.entity.Priority;
import com.taskmanager.demo.database.entity.Status;
import com.taskmanager.demo.database.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class TaskCreateEditDto {

    @NotBlank(message = "Title cannot be blank")
    String title;

    String description;

    @NotNull(message = "Status cannot be null")
    Status status;

    @NotNull(message = "Priority cannot be null")
    Priority priority;


    Long executorId;


    @NotNull(message = "Author ID cannot be null")
    Long authorId;
}
