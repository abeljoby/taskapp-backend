package com.abel.taskapp_backend.controller;

import com.abel.taskapp_backend.entity.Task;
import com.abel.taskapp_backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks/v1")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService TaskService;

    // GET ALL TASKS
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(TaskService.getAllTasks());
    }

    // GET A TASK
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(TaskService.getTaskById(id));
    }

    // CREATE A TASK
    @PostMapping("/")
    public ResponseEntity<Task> saveTask(@RequestBody Task Task)
    {
        return ResponseEntity.ok().body(TaskService.saveTask(Task));
    }

    // UPDATE TASK
    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@RequestBody Task Task)
    {
        return ResponseEntity.ok().body(TaskService.updateTask(Task));
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Integer id)
    {
        TaskService.deleteTaskById(id);
        return ResponseEntity.ok().body("Deleted Task successfully");
    }

}
