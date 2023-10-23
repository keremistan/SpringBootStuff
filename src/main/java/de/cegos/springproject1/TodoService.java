package de.cegos.springproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

//    @Autowired
    TodoRepository todoRepository;

    List<Todo> todos;

    public TodoService(TodoRepository todoRepository){
//    public TodoService(){
        todos = new ArrayList<>();
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos(){
        return todos;
//        return todoRepository.findAll();
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public void save(){
//        todoRepository.
    }

}
