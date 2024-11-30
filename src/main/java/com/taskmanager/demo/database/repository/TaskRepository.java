package com.taskmanager.demo.database.repository;

import com.taskmanager.demo.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByAuthorId(Long authorId);

    List<Task> findAllByExecutorId(Long executorId);
}
