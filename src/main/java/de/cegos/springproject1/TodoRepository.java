package de.cegos.springproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository{

//    @Autowired
//    TodoService todoService;

    public List<Todo> findAll(){
//        return todoService.todos;
        return List.of();
    }

}
