package com.example.todo.infrastructure;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryTodoRepository implements TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todos);
    }

    @Override
    public Todo findById(UUID id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void delete(UUID id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }
}