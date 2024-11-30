package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Comment;
import com.taskmanager.demo.dto.CommentReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentReadMapper implements Mapper<Comment, CommentReadDto> {

    private final TaskReadMapper taskReadMapper;
    private final UserReadMapper userReadMapper;

    @Override
    public CommentReadDto map(Comment object) {
        return new CommentReadDto(
                object.getId(),
                taskReadMapper.map(object.getTask()),
                userReadMapper.map(object.getUser()),
                object.getContent(),
                object.getCreatedAt(),
                object.getUpdatedAt()
        );
    }
}
