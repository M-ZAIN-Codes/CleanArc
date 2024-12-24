package com.example.todo.application;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoRepository;

import java.util.List;
import java.util.UUID;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id);
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(UUID id) {
        todoRepository.delete(id);
    }
}