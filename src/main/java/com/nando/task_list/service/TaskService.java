package com.nando.task_list.service;

import com.nando.task_list.domain.Task;
import com.nando.task_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public Task findById(String id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public List<Task> findByName(String name) {
        List<Task> tasks = taskRepository.findByName(name);
        return tasks;
    }

    public String delete(String id) {
        this.taskRepository.deleteById(id);
        return HttpStatus.OK.toString();
    }

    public Task save(Task task) {
        task.setCompleted(false);
        return this.taskRepository.save(task);
    }

    public Task updateStatus(String id) {
        Optional<Task> task = this.taskRepository.findById(id);

        if(task.isPresent()) {
            task.get().setCompleted(!task.get().getCompleted());
            this.taskRepository.save(task.get());
        }

        return task.orElse(null);
    }

}
