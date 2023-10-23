package de.cegos.springproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class GetTodos {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/")
    public String hello(){
        return "Kerem";
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/text")
    public String addTodo(@RequestBody Todo todo){
        System.out.printf("Received todo: %s", todo);
        todoService.addTodo(todo);
        return "success";
    }

    @PostMapping(value = "/getTodos", consumes = "application/json", produces = "application/text")
    public String getTodo(@RequestBody Long id){
        var allTodos = todoService.getTodos();
        var foundTodo = allTodos.stream().filter(td -> Objects.equals(td.getId(), id));
        return foundTodo.toList().get(0).getDescription();
    }

    @RequestMapping(value = "/getAllTodos")
    public List<Todo> getAllTodos(){
        return  todoService.getTodos();
    }

}
