/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo.repository;

import com.example.todo.model.TodoTask;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class TodoTaskRepository {
    private List<TodoTask> tasks = new ArrayList();
    
    public TodoTaskRepository(){
        tasks.add(new TodoTask(UUID.randomUUID().toString(),"Dummy task 1"));
        tasks.add(new TodoTask(UUID.randomUUID().toString(),"Dummy task 2"));
        tasks.add(new TodoTask(UUID.randomUUID().toString(),"Dummy task 3"));
    }
    
    public List<TodoTask> findAll(){
        return tasks;
    }
    
    public TodoTask findById(String id){
      return tasks.stream()
              .filter(task -> task.getId().equals(id))
              .findFirst()
              .orElse(null);
    }
    
    public TodoTask create(TodoTask task){
        tasks.add(task);
        return task;
    }

    public void update(TodoTask task, String id) {
        TodoTask existing = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Todo Task not found"));
        int index = tasks.indexOf(existing);
        tasks.set(index, task);
    }
    
    public void delete(String id){
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
