package de.cegos.springproject1;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class TodoRepositoryMem implements TodoRepository{

//    @Autowired
//    TodoService todoService;

    public List<Todo> findAll(){
//        return todoService.todos;
        return List.of();
    }


}
