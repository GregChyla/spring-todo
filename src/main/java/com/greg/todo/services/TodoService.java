package com.greg.todo.services;

import com.greg.todo.model.Todo;
import com.greg.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return repository.save(todo);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }

    public void updateTodo(Long id) {
        Optional<Todo> todo = findTodoById(id);
        if (todo.isPresent()) {
            todo.get().setCompleted(!todo.get().getCompleted());
            repository.save(todo.get());
        }
    }

    private Optional<Todo> findTodoById(Long id) {
        return repository.findById(id);
    }
}
