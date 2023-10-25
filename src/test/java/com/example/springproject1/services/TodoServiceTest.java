package com.example.springproject1.services;

import com.example.springproject1.data.Todo;
import com.example.springproject1.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TodoServiceTest {

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    ArrayList<Todo> todos;

    @BeforeEach
    void setup(){
        todos = new ArrayList<Todo>();
        Todo todo1 = new Todo();
        todo1.setDescription("Task1");
        todos.add(todo1);
    }

    @Test
    void getTodos() {
        when(todoRepository.findAll()).thenReturn(todos);

        assertEquals(todoService.getTodos(), todos);
    }

    @Test
    void getATodo() {
        when(todoRepository.findByDescription("Task1")).thenReturn(todos.get(0));
        when(todoRepository.findByDescription("Task2")).thenReturn(null);

        assertEquals(todoService.findByDescription("Task1"), todos.get(0));
        assertNull(todoService.findByDescription("Task2"));
    }
}