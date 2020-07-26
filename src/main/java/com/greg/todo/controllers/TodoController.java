package com.greg.todo.controllers;

import com.greg.todo.model.Todo;
import com.greg.todo.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/")
    public String todo() {
        return "index";
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }
}
