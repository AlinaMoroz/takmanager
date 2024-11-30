package com.taskmanager.demo.database.repository;

import com.taskmanager.demo.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment>findAllByTaskId(Long taskId);
}
