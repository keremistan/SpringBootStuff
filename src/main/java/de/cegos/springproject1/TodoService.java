package de.cegos.springproject1;

import de.cegos.springproject1.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void addTodo(Todo todo){
        todoRepository.save(todo);
        System.out.println("Saved to repo");
    }


}
