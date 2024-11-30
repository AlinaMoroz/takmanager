package com.taskmanager.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CommentCreateDto {

    @NotNull(message = "Task ID cannot be null")
    Long taskId;

    @NotNull(message = "User ID cannot be null")
    Long userId;

    @NotBlank(message = "Content cannot be blank")
    @Size(min = 1, max = 500, message = "Content must be between 1 and 500 characters")
    String content;
}
