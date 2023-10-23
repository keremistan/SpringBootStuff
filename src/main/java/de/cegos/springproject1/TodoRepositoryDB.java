package de.cegos.springproject1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class TodoRepositoryDB implements TodoRepository{

//    @Autowired
//    TodoService todoService;

    public List<Todo> findAll(){
//        return todoService.todos;
        return List.of();
    }


}
