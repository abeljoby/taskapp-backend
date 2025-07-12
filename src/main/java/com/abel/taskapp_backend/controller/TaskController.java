package com.abel.taskapp_backend.controller;

import com.abel.taskapp_backend.entity.Task;
import com.abel.taskapp_backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class is where all the user requests are handled and required/appropriate
 * responses are sent
 */
@RestController
@RequestMapping("/tasks/v1")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService TaskService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/Task/v1/
     * Purpose: Fetches all the Tasks in the Task table
     * @return List of Tasks
     */
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(TaskService.getAllTasks());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/Task/v1/1 (or any other id)
     * Purpose: Fetches Task with the given id
     * @param id - Task id
     * @return Task with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(TaskService.getTaskById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/Task/v1/
     * Purpose: Save an Task entity
     * @param Task - Request body is an Task entity
     * @return Saved Task entity
     */
    @PostMapping("/")
    public ResponseEntity<Task> saveTask(@RequestBody Task Task)
    {
        return ResponseEntity.ok().body(TaskService.saveTask(Task));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/Task/v1/
     * Purpose: Update an Task entity
     * @param Task - Task entity to be updated
     * @return Updated Task
     */
    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@RequestBody Task Task)
    {
        return ResponseEntity.ok().body(TaskService.updateTask(Task));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/Task/v1/1 (or any other id)
     * Purpose: Delete an Task entity
     * @param id - Task's id to be deleted
     * @return a String message indicating Task record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Integer id)
    {
        TaskService.deleteTaskById(id);
        return ResponseEntity.ok().body("Deleted Task successfully");
    }


}
