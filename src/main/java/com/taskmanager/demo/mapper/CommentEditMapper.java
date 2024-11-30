package com.taskmanager.demo.mapper;

import com.taskmanager.demo.database.entity.Comment;
import com.taskmanager.demo.dto.CommentEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentEditMapper implements Mapper<CommentEditDto, Comment> {
    @Override
    public Comment map(CommentEditDto object) {
        return null;
    }

    @Override
    public Comment map(CommentEditDto object, Comment toObject) {
        toObject.setContent(object.getContent());
        return toObject;
    }
}
