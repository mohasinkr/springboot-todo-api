package com.mkr.todo.controller;

import com.mkr.todo.model.ToDo;
import com.mkr.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {

    private ToDoService todoService;

    @Autowired
    public void TodoController(ToDoService todoservice) {
        this.todoService = todoservice;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Optional<ToDo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }

    @PostMapping
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo newTodo) {
        ToDo created = todoService.createTodo(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ToDo updateTodo(@PathVariable Long id, @RequestBody ToDo todo) {
        return todoService.updateTodo(id, todo);
    }
}
