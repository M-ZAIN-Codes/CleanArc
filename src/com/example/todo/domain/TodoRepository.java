package com.example.todo.domain;

import java.util.List;
import java.util.UUID;

public interface TodoRepository {
    List<Todo> findAll();
    Todo findById(UUID id);
    void save(Todo todo);
    void delete(UUID id);
}