package org.example.taskmanager.controller;

import org.example.taskmanager.model.Status;
import org.example.taskmanager.model.Task;
import org.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public record CreateTaskRequest(String title, String description) {}

    @PostMapping
    public Task createTask(@RequestBody CreateTaskRequest request) {
        System.out.println("salom");
        return taskService.createTask(request.title(), request.description());
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable UUID id, @RequestParam Status status) {
        return taskService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }
}