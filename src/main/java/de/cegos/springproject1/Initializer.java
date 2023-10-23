package de.cegos.springproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

    @Autowired
    private TodoService todoService;

    @Override
    public void run(String... args) throws Exception {
        Todo todo1 = new Todo(1l, "task1");
        Todo todo2 = new Todo(2l, "task2");
        Todo todo3 = new Todo(3l, "task3");

        todoService.addTodo(todo1);
        todoService.addTodo(todo2);
        todoService.addTodo(todo3);

        var todos = todoService.getTodos();
        System.out.printf("The todos: %s\n", todos);

    }
}
