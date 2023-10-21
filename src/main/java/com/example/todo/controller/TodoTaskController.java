/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo.controller;

import com.example.todo.model.TodoTask;
import com.example.todo.repository.TodoTaskRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/tasks")
public class TodoTaskController {

    private final TodoTaskRepository repository;

    public TodoTaskController(TodoTaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TodoTask> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public TodoTask findById(@PathVariable String id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TodoTask create(@RequestBody TodoTask task) {
        return repository.create(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody TodoTask task, @PathVariable String id) {
        repository.update(task, id);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }

}
