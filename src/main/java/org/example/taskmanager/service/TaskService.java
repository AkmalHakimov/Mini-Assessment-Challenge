package org.example.taskmanager.service;

import org.example.taskmanager.model.Status;
import org.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TaskService {

    private final Map<UUID, Task> tasks = new HashMap<>();

    public Task createTask(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }

        Task task = new Task(
                UUID.randomUUID(),
                title,
                description,
                Status.TODO,
                LocalDateTime.now()
        );

        tasks.put(task.getId(), task);
        return task;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public Task updateStatus(UUID id, Status status) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new NoSuchElementException("Task not found");
        }
        task.setStatus(status);
        return task;
    }

    public void deleteTask(UUID id) {
        if (!tasks.containsKey(id)) {
            throw new NoSuchElementException("Task not found");
        }
        tasks.remove(id);
    }
}
