package com.nando.task_list.controller;

import com.nando.task_list.domain.Task;
import com.nando.task_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return this.taskService.listAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id) {
        return this.taskService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Task> findByName(@PathVariable String name) {
        return this.taskService.findByName(name);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return this.taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        this.taskService.delete(id);
    }

    @PutMapping("updateStatus/{id}")
    public Task updateTask(@PathVariable String id) {
        return this.taskService.updateStatus(id);
    }
}
