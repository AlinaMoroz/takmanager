package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Comment;
import com.taskmanager.demo.database.entity.Task;
import com.taskmanager.demo.database.entity.User;
import com.taskmanager.demo.database.repository.TaskRepository;
import com.taskmanager.demo.database.repository.UserRepository;
import com.taskmanager.demo.dto.CommentCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CommentCreateMapper implements Mapper<CommentCreateDto, Comment> {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public Comment map(CommentCreateDto object) {
        Comment comment = new Comment();
        comment.setUser(getUser(object.getUserId()));
        comment.setTask(getTask(object.getTaskId()));
        comment.setContent(object.getContent());

        return comment;
    }

    private User getUser(Long userId) {
        return Optional.ofNullable(userId)
                .flatMap(userRepository::findById)
                .orElseThrow();
    }

    private Task getTask(Long taskId) {
        return Optional.ofNullable(taskId)
                .flatMap(taskRepository::findById)
                .orElseThrow();
    }
}
