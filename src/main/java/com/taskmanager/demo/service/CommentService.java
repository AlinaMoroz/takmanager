package com.taskmanager.demo.service;

import com.taskmanager.demo.database.repository.CommentRepository;
import com.taskmanager.demo.dto.CommentCreateDto;
import com.taskmanager.demo.dto.CommentEditDto;
import com.taskmanager.demo.dto.CommentReadDto;
import com.taskmanager.demo.mapper.CommentCreateMapper;
import com.taskmanager.demo.mapper.CommentEditMapper;
import com.taskmanager.demo.mapper.CommentReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentReadMapper commentReadMapper;
    private final CommentCreateMapper commentCreateMapper;
    private final CommentEditMapper commentEditMapper;

    @Transactional
    public CommentReadDto create(CommentCreateDto commentCreateDto) {
        var comment = commentRepository.save(commentCreateMapper.map(commentCreateDto));
        return commentReadMapper.map(comment);
    }

    @Transactional
    public Optional<CommentReadDto> update(Long commentId, CommentEditDto commentUpdateDto) {
        return commentRepository.findById(commentId)
                .map(entity -> {
                    return commentEditMapper.map(commentUpdateDto, entity);
                }).map(commentRepository::saveAndFlush)
                .map(commentReadMapper::map);
    }

    @Transactional
    public boolean delete(Long commentId) {
        return commentRepository.findById(commentId)
                .map(entity -> {
                    commentRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }

    public Optional<CommentReadDto> findById(Long commentId){
        return commentRepository.findById(commentId)
                .map(commentReadMapper::map);
    }

    public List<CommentReadDto> findByTaskId(Long taskId){
        return commentRepository.findAllByTaskId(taskId)
                .stream().map(commentReadMapper::map)
                .collect(Collectors.toList());
    }
}
