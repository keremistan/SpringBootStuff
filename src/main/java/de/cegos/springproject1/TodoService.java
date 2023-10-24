package de.cegos.springproject1;

import de.cegos.springproject1.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
