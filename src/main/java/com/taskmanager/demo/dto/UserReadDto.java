package com.taskmanager.demo.dto;

import jakarta.validation.constraints.Email;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserReadDto {
    Long id;

    String email;

    String firstName;

    String lastName;


}
