package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.User;
import com.taskmanager.demo.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {
    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);

        return user;
    }

    @Override
    public User map(UserCreateEditDto object, User toObject) {
        copy(object, toObject);
        return toObject;
    }

    private void copy(UserCreateEditDto object, User user) {
        user.setEmail(object.getEmail());
        user.setPassword(object.getPassword());
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());


    }
}
