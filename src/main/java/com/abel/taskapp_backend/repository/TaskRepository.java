package com.abel.taskapp_backend.repository;

import com.abel.taskapp_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
