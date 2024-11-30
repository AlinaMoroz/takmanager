package com.taskmanager.demo.service;

import com.taskmanager.demo.database.repository.UserRepository;
import com.taskmanager.demo.dto.UserCreateEditDto;
import com.taskmanager.demo.dto.UserReadDto;
import com.taskmanager.demo.mapper.UserCreateEditMapper;
import com.taskmanager.demo.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;
    private final UserRepository userRepository;

    @Transactional
    public UserReadDto create(UserCreateEditDto userCreateEditDto) {
        var entity = userRepository.save(userCreateEditMapper.map(userCreateEditDto));
        return userReadMapper.map(entity);
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<UserReadDto> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userReadMapper::map);
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userCreateEditDto) {
        return userRepository.findById(id)
                .map(entity -> {
                    return userCreateEditMapper.map(userCreateEditDto, entity);
                })
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    return true;
                }).orElse(false);
    }


}
