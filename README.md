# Task Manager API

A simple backend REST API built with **Java and Spring Boot** that demonstrates clean API design, basic business logic, and proper project structure.

## Tech Stack

* Java 11+
* Spring Boot
* Spring Web
* In-memory storage (no database)

---

## Project Structure

```
org.example.taskmanager
├── TaskmanagerApplication.java
├── controller
│   └── TaskController.java
├── service
│   └── TaskService.java
└── model
    ├── Task.java
    └── Status.java
```

---

## Features

* Create tasks
* Retrieve all tasks
* Update task status
* Delete tasks
* Input validation
* RESTful API design

---

## Base URL

```
http://localhost:8080/t
```

---

## API Endpoints

### Create Task

```
POST /t/tasks
```

**Request Body**

```json
{
  "title": "Finish assessment",
  "description": "Backend challenge"
}
```

---

### Get All Tasks

```
GET /t/tasks
```

---

### Update Task Status

```
PUT /t/tasks/{id}/status?status=DONE
```

**Status values**

```
TODO | IN_PROGRESS | DONE
```

---

### Delete Task

```
DELETE /t/tasks/{id}
```

---

## Design Notes

* In-memory storage is used to keep the focus on backend logic.
* Business logic is isolated in the service layer.
* Enum-based task status prevents invalid state transitions.
* Context path (`/t`) allows easy API versioning or prefixing.

---

## How to Run

1. Open the project in IntelliJ IDEA
2. Run `TaskmanagerApplication`
3. Server starts on port `8080`
4. Test endpoints using Postman or curl

---

## Example Response

```json
{
  "id": "uuid",
  "title": "Finish assessment",
  "description": "Backend challenge",
  "status": "TODO",
  "createdAt": "2026-01-27T22:10:00"
}
```

---

## Notes

* No authentication implemented
* No database integration
* Single-user scope
* Intended as a backend assessment project

---
