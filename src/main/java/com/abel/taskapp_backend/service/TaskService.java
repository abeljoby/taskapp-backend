package com.abel.taskapp_backend.service;

import com.abel.taskapp_backend.entity.Task;
import com.abel.taskapp_backend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository TaskRepo;

    public List<Task> getAllTasks(){
        return TaskRepo.findAll();
    }

    public Task getTaskById(Integer id){
        Optional<Task> optionalTask = TaskRepo.findById(id);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        log.info("Task with id: {} doesn't exist", id);
        return null;
    }

    public Task saveTask (Task Task){
        Task.setCreatedAt(LocalDateTime.now());
        Task.setUpdatedAt(LocalDateTime.now());
        Task savedTask = TaskRepo.save(Task);

        log.info("Task with id: {} saved successfully", Task.getId());
        return savedTask;
    }

    public Task updateTask (Task Task) {
        Optional<Task> existingTask = TaskRepo.findById(Task.getId());
        Task.setCreatedAt(existingTask.get().getCreatedAt());
        Task.setUpdatedAt(LocalDateTime.now());

        Task updatedTask = TaskRepo.save(Task);

        log.info("Task with id: {} updated successfully", Task.getId());
        return updatedTask;
    }

    public void deleteTaskById (Integer id) {
        TaskRepo.deleteById(id);
    }

}