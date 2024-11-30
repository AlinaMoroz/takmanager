package com.taskmanager.demo.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CommentReadDto {
    Long id;

    TaskReadDto task;

    UserReadDto user;

    String content;

    LocalDateTime createAt;

    LocalDateTime updateAt;


}
