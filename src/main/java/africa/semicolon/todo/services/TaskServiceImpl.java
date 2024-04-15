package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.repositories.TaskRepository;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import africa.semicolon.todo.dtos.requests.UpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setDetails(createTaskRequest.getDetails());
        task.setTitle(createTaskRequest.getTitle());
        task.setReminder(createTaskRequest.getReminder());
         taskRepository.save(task);
        return task;
    }

    @Override
    public Task updateTask(UpdateRequest update) {
       Task task = findTaskById(update.getId());
     if (update.getNewTitle() != null) {
         task.setTitle(update.getNewTitle());
     }
      if (update.getNewDetails() != null) {
          task.setDetails(update.getNewDetails());
      }
       if (update.getReminder() != null) {
           task.setReminder(update.getReminder());
       }
       taskRepository.save(task);
       return task;
    }

    @Override
    public void deleteParticularTask(String id) {
        Task task = findTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    public Task findTaskById(String id) {
       return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Task> findParticularTaskInADay(String todoId, Date dateCreated) {

        return null;
    }
}