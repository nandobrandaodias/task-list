package com.nando.task_list.repository;

import com.nando.task_list.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, String> {
    public List<Task> findByName(String name);
}
