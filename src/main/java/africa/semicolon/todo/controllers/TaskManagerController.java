package africa.semicolon.todo.controllers;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.model.TaskManager;
import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.data.repositories.TaskManagerRepository;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import africa.semicolon.todo.dtos.requests.DeleteATaskRequest;
import africa.semicolon.todo.services.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/task-manager")
public class TaskManagerController {
    @Autowired
    private TaskManagerService taskManagerService;



    @PostMapping("/createTaskManager")
    public ResponseEntity<?> createTaskManager(@RequestBody User user) {
        try {
            TaskManager createdTaskManager = taskManagerService.createTaskManager(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskManager);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create task manager: " + e.getMessage());
        }
    }
    @GetMapping("/user-tasks")
    public ResponseEntity<?> viewAllTasks(@RequestBody User user) {
        try {
            ArrayList<Task> allTasks = taskManagerService.viewAllTasks(user);
            return ResponseEntity.ok(allTasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve tasks: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete-user-tasks")
    public ResponseEntity<?> deleteTask(@RequestBody DeleteATaskRequest deleteTaskRequest) {
        try {
            ArrayList<Task> updatedTasks = taskManagerService.deleteTasks(deleteTaskRequest);
            return ResponseEntity.ok(updatedTasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete task: " + e.getMessage());
        }
    }

    @PostMapping("/tasks/create")
    public ResponseEntity<?> createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        try {
            Task createdTask = taskManagerService.createTask(createTaskRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create task: " + e.getMessage());
        }
    }
}