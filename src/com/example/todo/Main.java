package com.example.todo;

import com.example.todo.application.TodoService;
import com.example.todo.infrastructure.InMemoryTodoRepository;
import com.example.todo.presentation.TodoController;
import com.example.todo.domain.Todo;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository, service, and controller
        InMemoryTodoRepository repository = new InMemoryTodoRepository();
        TodoService service = new TodoService(repository);
        TodoController controller = new TodoController(service);

        // Add some todos
        controller.addTodo("Buy groceries", "Milk, Bread, Eggs");
        controller.addTodo("Read a book", "The Clean Architecture");

        // Retrieve and display all todos
        List<Todo> todos = controller.getAllTodos();
        System.out.println("All Todos:");
        for (Todo todo : todos) {
            System.out.println("ID: " + todo.getId() + ", Title: " + todo.getTitle() + ", Description: " + todo.getDescription());
        }

        // Example of deleting a todo
        if (!todos.isEmpty()) {
            UUID todoIdToDelete = todos.get(0).getId(); // Get the ID of the first todo
            controller.deleteTodo(todoIdToDelete);
            System.out.println("Deleted Todo with ID: " + todoIdToDelete);
        }

        // Display remaining todos
        todos = controller.getAllTodos();
        System.out.println("Remaining Todos:");
        for (Todo todo : todos) {
            System.out.println("ID: " + todo.getId() + ", Title: " + todo.getTitle() + ", Description: " + todo.getDescription());
        }
    }
}