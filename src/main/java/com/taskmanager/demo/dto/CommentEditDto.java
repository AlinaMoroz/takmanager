package com.taskmanager.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CommentEditDto {

    @NotBlank(message = "Content cannot be blank")
    @Size(min = 1, max = 500, message = "Content must be between 1 and 500 characters")
    String content;
}
