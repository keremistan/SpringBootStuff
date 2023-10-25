package com.example.springproject1.configs;

import com.example.springproject1.repository.TodoRepository;
import com.example.springproject1.services.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoAppConfig {
    @Bean
    public TodoService getTodoService(TodoRepository todoRepository){
        return new TodoService(todoRepository);
    }
}
