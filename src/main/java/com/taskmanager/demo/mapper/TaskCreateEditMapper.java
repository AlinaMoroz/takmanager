package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Task;
import com.taskmanager.demo.database.entity.User;
import com.taskmanager.demo.database.repository.UserRepository;
import com.taskmanager.demo.dto.TaskCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TaskCreateEditMapper implements Mapper<TaskCreateEditDto, Task> {

    private final UserRepository userRepository;

    @Override
    public Task map(TaskCreateEditDto object) {

        Task task = new Task();
        copy(object, task);
        return task;
    }

    @Override
    public Task map(TaskCreateEditDto object, Task toObject) {
        copy(object, toObject);
        return toObject;
    }

    private void copy(TaskCreateEditDto object, Task task) {
        task.setTitle(object.getTitle());
        task.setDescription(object.getDescription());
        task.setStatus(object.getStatus());
        task.setPriority(object.getPriority());
        task.setExecutor(getUser(object.getExecutorId()));
        task.setAuthor(getUser(object.getAuthorId()));
    }

    private User getUser(Long authorId) {
        return Optional.ofNullable(authorId)
                .flatMap(userRepository::findById)
                .orElse(null);

    }
}
