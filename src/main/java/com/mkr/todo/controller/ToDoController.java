package com.mkr.todo.controller;

import com.mkr.todo.model.ToDo;
import com.mkr.todo.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return toDoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getTodoById(@PathVariable Long id) {
        return toDoService.getTodoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo toDo) {
        return toDoService.createTodo(toDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable Long id, @RequestBody ToDo updatedToDo) {
        try {
            return ResponseEntity.ok(toDoService.updateTodo(id, updatedToDo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        toDoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
