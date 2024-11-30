package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.User;
import com.taskmanager.demo.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {
    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                object.getId(),
                object.getEmail(),
                object.getFirstName(),
                object.getLastName()
        );
    }
}
