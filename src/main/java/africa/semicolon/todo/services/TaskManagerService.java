package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.model.TaskManager;
import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import africa.semicolon.todo.dtos.requests.DeleteATaskRequest;

import java.util.ArrayList;

public interface TaskManagerService {
//    boolean isLocked(String email, String password);
    ArrayList<Task> viewAllTasks(User user);
    TaskManager createTaskManager(User user);
    TaskManager findTaskManagerByUser(User user);
    ArrayList<Task> deleteTasks(DeleteATaskRequest deleteATaskRequest);
    Task createTask(CreateTaskRequest createTaskRequest);
}
