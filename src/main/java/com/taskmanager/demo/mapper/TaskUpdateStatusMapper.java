package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Status;
import com.taskmanager.demo.database.entity.Task;
import com.taskmanager.demo.dto.TaskUpdateStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TaskUpdateStatusMapper implements Mapper<TaskUpdateStatusDto, Task> {


    @Override
    public Task map(TaskUpdateStatusDto object) {
        return null;
    }

    @Override
    public Task map(TaskUpdateStatusDto object, Task toObject) {
        toObject.setStatus(object.getStatus());
        return toObject;
    }
}
