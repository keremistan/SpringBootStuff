package de.cegos.springproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springproject1Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Springproject1Application.class, args);

		TodoService todoService = ac.getBean(TodoService.class);
		Todo todo1 = new Todo(1l, "task1");
		Todo todo2 = new Todo(2l, "task2");
		Todo todo3 = new Todo(3l, "task3");

		todoService.addTodo(todo1);
		todoService.addTodo(todo2);
		todoService.addTodo(todo3);

		var todos = todoService.getTodos();
		System.out.printf("\nThe todos: %s\n", todos);
	}

}
