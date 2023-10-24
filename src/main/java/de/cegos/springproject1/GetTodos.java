package de.cegos.springproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @GetMapping(value = "/todo")
    public String getTodo(@RequestParam String id){
        return todoService.getATodo(id);
    }

    @RequestMapping(value = "/getAllTodos")
    public List<Todo> getAllTodos(){
        return  todoService.getTodos();
    }

    @PutMapping(value = "/todo", consumes = "application/json")
    public String updateTodo(@RequestParam Long id, @RequestBody String reqBody){
        System.out.printf("Received id: %s\n", id);
        System.out.printf("Received reqBody: %s\n", reqBody);
        todoService.updateTodo(id, reqBody); // reqBody is a whole json-string. But it updates the todo in db, so...
        return "Update completed";
    }

    @DeleteMapping(value = "/todo", consumes = "application/json")
    public String deleteTodo(@RequestParam Long id){
        todoService.deleteTodo(id);
        return "Delete successful";
    }

    @GetMapping(value = "/todoByDescription")
    public String getByDescription(@RequestParam String description){
        System.out.printf("Received description: %s\n", description);
        var todo = todoService.findByDescription(description);
        System.out.printf("Fetched todo: %s\n", todo);
        return todo.toString();
    }


}
