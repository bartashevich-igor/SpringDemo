package com.example.SpringDemo.controller;

import com.example.SpringDemo.model.Task;
import com.example.SpringDemo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getById(@PathVariable Long id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() ->new Exception("No tasks found"));
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskRepository.saveAndFlush(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patch(@PathVariable Long id, @RequestBody Task task) {
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patch(@PathVariable Long id) {
        taskRepository.markAsDone(id);
    }
}
