package com.example.springproject1.configs;

import com.example.springproject1.data.Todo;
import com.example.springproject1.services.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

    private TodoService todoService;

    public Initializer(TodoService todoService){
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) throws Exception {
        Todo todo1 = new Todo();
        todo1.setDescription("Task 1");

        todoService.addTodo(todo1);

        var todos = todoService.getTodos();
        System.out.printf("The todos: %s\n", todos);
    }
}
