package com.example.springproject1.services;

import com.example.springproject1.data.Todo;
import com.example.springproject1.repository.TodoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TodoService {

//    @Autowired
    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public String getATodo(String id){
        var todo = todoRepository.findById(Long.parseLong(id));
        if(todo.isPresent()){
            return todo.get().getDescription();
        }else{
            return "couldnt find the todo with given id";
        }
    }

    @Transactional
    public void addTodo(Todo todo){
        todoRepository.save(todo);
        System.out.println("Saved to repo");
    }

    public void updateTodo(Long id, String description){
        var todo = todoRepository.findById(id).get();
        todo.setDescription(description);
        todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public Todo findByDescription(String description){
        var todo = todoRepository.findByDescription(description);
        return todo;
    }

    public List<Todo> getPriorTodos(Long id){
        return todoRepository.findPriorTodos(id);
    }

}
