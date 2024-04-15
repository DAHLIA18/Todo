package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import africa.semicolon.todo.dtos.requests.UpdateRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
public interface TaskService {

    Task createTask(CreateTaskRequest createTaskRequest);
    Task updateTask(UpdateRequest update);

    void deleteParticularTask(String id);

    Task findTaskById(String id);

    List<Task> findParticularTaskInADay(String todoId, Date dateCreated);
}
