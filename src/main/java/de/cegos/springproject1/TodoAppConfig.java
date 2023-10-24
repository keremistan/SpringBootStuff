package de.cegos.springproject1;

import de.cegos.springproject1.repository.TodoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoAppConfig {
    @Bean
    public TodoService getTodoService(TodoRepository todoRepository){
        return new TodoService(todoRepository);
    }
}
