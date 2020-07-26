package com.greg.todo.services;

import com.greg.todo.model.Todo;
import com.greg.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }
}
