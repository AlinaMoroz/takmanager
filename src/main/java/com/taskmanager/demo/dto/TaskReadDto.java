package com.taskmanager.demo.dto;

import com.taskmanager.demo.database.entity.Priority;
import com.taskmanager.demo.database.entity.Status;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskReadDto {
    Long id;

    String title;

    String description;

    Status status;

    Priority priority;

    UserReadDto author;

    UserReadDto executor;

    LocalDateTime createdAt;

    LocalDateTime updateAt;
}
