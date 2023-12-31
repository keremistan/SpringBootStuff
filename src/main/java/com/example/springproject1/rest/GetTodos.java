package com.example.springproject1.rest;

import com.example.springproject1.data.Todo;
import com.example.springproject1.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class GetTodos {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Kerem", HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addTodo(@RequestBody Todo todo){
        System.out.printf("Received todo: %s", todo);
        todoService.addTodo(todo);
        return ResponseEntity.ok("Success");
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

    @GetMapping(value = "/priorTodos")
    public List<Todo> getTodos(@RequestParam Long id){
        return todoService.getPriorTodos(id);
    }

}
