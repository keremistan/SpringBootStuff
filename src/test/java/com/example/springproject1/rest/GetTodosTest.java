package com.example.springproject1.rest;

import com.example.springproject1.data.Todo;
import com.example.springproject1.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetTodos.class)
class GetTodosTest {

    ArrayList<Todo> todos;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @BeforeEach
    void setup() {
        todos = new ArrayList<>();
        Todo todo1 = new Todo();
        todo1.setDescription("Task1");
        todos.add(todo1);
    }


    @Test
    void getTodo() {
    }

    @Test
    void getAllTodos() throws Exception {
        when(todoService.getTodos()).thenReturn(todos);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/getAllTodos"))
                .andDo(System.out::println)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Task1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").doesNotExist());
    }
}