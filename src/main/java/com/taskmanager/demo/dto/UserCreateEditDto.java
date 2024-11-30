package com.taskmanager.demo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class UserCreateEditDto {
    @Email
    String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    @NotNull(message = "Password cannot be null")
    String password;

    @NotNull(message = "First name cannot be null")
    String firstName;

    @NotNull(message = "Last name cannot be null")
    String lastName;

}
