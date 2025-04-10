package com.mkr.todo.service;

import com.mkr.todo.model.ToDo;
import com.mkr.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getTodoById(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo createTodo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo updateTodo(Long id, ToDo updatedToDo) {
        return toDoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedToDo.getTitle());
                    todo.setCompleted(updatedToDo.isCompleted());
                    return toDoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("ToDo not found"));
    }

    public void deleteTodoById(Long id) {
        toDoRepository.deleteById(id);
    }
}
