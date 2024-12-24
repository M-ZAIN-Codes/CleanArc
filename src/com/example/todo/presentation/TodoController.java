package com.example.todo.presentation;

import com.example.todo.application.TodoService;
import com.example.todo.domain.Todo;

import java.util.List;
import java.util.UUID;

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    public Todo getTodoById(UUID id) {
        return todoService.getTodoById(id);
    }

    public void addTodo(String title, String description) {
        Todo todo = new Todo(UUID.randomUUID(), title, description);
        todoService.addTodo(todo);
    }

    public void deleteTodo(UUID id) {
        todoService.deleteTodo(id);
    }
}