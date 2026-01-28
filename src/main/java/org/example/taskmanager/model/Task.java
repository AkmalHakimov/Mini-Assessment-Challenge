package org.example.taskmanager.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Task {

    private UUID id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime createdAt;

    public Task() {
        this.id = UUID.randomUUID();
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
    }

    public Task(UUID id, String title, String description, Status status, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        setTitle(title);
        setDescription(description);
        setStatus(status);
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Status getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(UUID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = (description == null) ? "" : description;
    }

    public void setStatus(Status status) {
        this.status = Objects.requireNonNull(status, "status must not be null");
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}