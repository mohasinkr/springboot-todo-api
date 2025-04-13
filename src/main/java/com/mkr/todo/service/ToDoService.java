package com.mkr.todo.service;

import com.mkr.todo.model.ToDo;
import com.mkr.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final TodoRepository todoRepository;
    private final LoggerService loggerService = LoggerService.getInstance();

    @Autowired
    public ToDoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public List<ToDo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<ToDo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public ToDo createTodo(ToDo toDo) {
        loggerService.log("Creating ToDo: " + toDo.getTitle());
        return todoRepository.save(toDo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public ToDo updateTodo(Long id, ToDo updatedToDo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedToDo.getTitle());
                    todo.setDescription(updatedToDo.getDescription());
                    todo.setCompleted(updatedToDo.isCompleted());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("ToDo not found"));
    }
}
