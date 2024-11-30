package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Task;
import com.taskmanager.demo.dto.TaskReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TaskReadMapper implements Mapper<Task, TaskReadDto> {

    private final UserReadMapper userReadMapper;

    @Override
    public TaskReadDto map(Task object) {
        return new TaskReadDto(
                object.getId(),
                object.getTitle(),
                object.getDescription(),
                object.getStatus(),
                object.getPriority(),
                userReadMapper.map(object.getAuthor()),
                userReadMapper.map(object.getExecutor()),
                object.getCreatedAt(),
                object.getUpdatedAt()
        );
    }


}
