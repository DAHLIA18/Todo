package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Work;
import africa.semicolon.todo.dtos.requests.CreateWorkRequest;
import africa.semicolon.todo.dtos.requests.UpdateWorkRequest;
import africa.semicolon.todo.dtos.responses.WorkResponse;

import java.util.List;

public interface WorkService {

    List<Work> getAllTask();

    String getWorkByTitle(String id);

    List<Work> getAllWork();
    String getTaskByTitle(String id);
    WorkResponse updateTask(UpdateWorkRequest work);

    String deleteTask(CreateWorkRequest request);

    long getCountOfTask();

    String taskDone(Work work);

    String workDone(Work work);

    void deleteTask(Work work);

    void deleteAll();

    Work findByTitle(String title);

    Work save(Work newWork);
}
