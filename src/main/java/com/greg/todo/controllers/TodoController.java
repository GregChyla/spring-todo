package com.greg.todo.controllers;

import com.greg.todo.exceptions.TodoExceptionHandler;
import com.greg.todo.model.Todo;
import com.greg.todo.services.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/")
    public String todo() {
        return "index";
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        model.addAttribute("todos", service.getAllTodos());
        return "todos";
    }

    @PostMapping("/todos")
    public String addTodo(@ModelAttribute Todo todo, Model model) {
        service.saveTodo(todo);
        model.addAttribute("todos", service.getAllTodos());
        return "redirect:/todos";
    }

    @PostMapping("/todosDel/{id}")
    public String deleteTodo(@PathVariable Long id, Model model) {
        service.deleteTodo(id);
        model.addAttribute("todos", service.getAllTodos());
        return "redirect:/todos";
    }

    @PostMapping("/todosPut/{id}")
    @ExceptionHandler(TodoExceptionHandler.class)
    public String changeState(@PathVariable Long id, Model model) {
            service.updateTodo(id);
            model.addAttribute("todos", service.getAllTodos());
            return "redirect:/todos";
    }





}







