package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.model.TodoList;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;

import java.util.ArrayList;

public interface TodoListService {
    boolean isLocked();
    ArrayList<Task> tasks ();
    Task createTask(CreateTaskRequest createTaskRequest);
    TodoList todo();
}
