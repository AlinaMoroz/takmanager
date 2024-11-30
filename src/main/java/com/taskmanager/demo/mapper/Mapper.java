package com.taskmanager.demo.mapper;

public interface Mapper<F, T> {

    T map(F object);

    default T map(F object, T toObject) {
        return toObject;
    }
}
