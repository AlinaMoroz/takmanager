package com.taskmanager.demo.service;

import com.taskmanager.demo.database.entity.Task;
import com.taskmanager.demo.database.repository.TaskRepository;
import com.taskmanager.demo.database.repository.UserRepository;
import com.taskmanager.demo.dto.*;
import com.taskmanager.demo.mapper.TaskAssignExecutorMapper;
import com.taskmanager.demo.mapper.TaskCreateEditMapper;
import com.taskmanager.demo.mapper.TaskReadMapper;
import com.taskmanager.demo.mapper.TaskUpdateStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskCreateEditMapper taskCreateEditMapper;
    private final TaskReadMapper taskReadMapper;
    private final TaskAssignExecutorMapper taskAssignExecutorMapper;
    private final TaskUpdateStatusMapper taskUpdateStatusMapper;

    private final UserRepository userRepository;

    @Transactional
    public TaskReadDto create(TaskCreateEditDto taskCreateEditDto) {
        var entity = taskRepository.save(taskCreateEditMapper.map(taskCreateEditDto));
        return taskReadMapper.map(entity);
    }

    @Transactional
    public Optional<TaskReadDto> update(Long id, TaskCreateEditDto taskCreateEditDto) {
        return taskRepository.findById(id).map(entity -> {
                    return taskCreateEditMapper.map(taskCreateEditDto, entity);
                })
                .map(taskRepository::saveAndFlush)
                .map(taskReadMapper::map);
    }

    @Transactional
    public Boolean delete(Long id) {
        return taskRepository.findById(id)
                .map(entity -> {
                    taskRepository.delete(entity);
                    return true;
                }).orElse(false);
    }

    public Optional<TaskReadDto> findById(Long id) {
        return taskRepository.findById(id).map(taskReadMapper::map);
    }

    public List<TaskReadDto> findAll() {
        return taskRepository.findAll()
                .stream().map(taskReadMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public void assignExecutor(TaskAssignExecutorDto taskAssignExecutorDto) {
        var user = userRepository.findById(taskAssignExecutorDto.getExecutorId()).orElseThrow();
        var task = taskRepository.findById(taskAssignExecutorDto.getTaskId()).orElseThrow();
        taskAssignExecutorMapper.map(user, task);

        taskRepository.saveAndFlush(task);
    }

    @Transactional
    public TaskReadDto updateStatus(TaskUpdateStatusDto taskUpdateStatusDto) {
        var task = taskRepository.findById(taskUpdateStatusDto.getTaskId()).orElseThrow();
        taskUpdateStatusMapper.map(taskUpdateStatusDto, task);
        var task1 = taskRepository.saveAndFlush(task);
        return taskReadMapper.map(task1);
    }

    public List<TaskReadDto> findByAuthorId(Long authorId) {
        return taskRepository.findAllByAuthorId(authorId)
                .stream().map(taskReadMapper::map)
                .collect(Collectors.toList());
    }

    public List<TaskReadDto> findByExecutorId(Long executorId) {
        return taskRepository.findAllByExecutorId(executorId)
                .stream().map(taskReadMapper::map)
                .collect(Collectors.toList());
    }
}
