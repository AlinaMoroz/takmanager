package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Task;
import com.taskmanager.demo.database.entity.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TaskAssignExecutorMapper implements Mapper<User, Task> {
    @Override
    public Task map(User object) {
        return null;
    }

    @Override
    public Task map(User object, Task toObject) {
        toObject.setExecutor(object);
        return toObject;
    }
}
