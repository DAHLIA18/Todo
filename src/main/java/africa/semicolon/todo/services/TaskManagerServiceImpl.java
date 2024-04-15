package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.model.TaskManager;
import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.data.repositories.TaskManagerRepository;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import africa.semicolon.todo.dtos.requests.DeleteATaskRequest;
import com.mongodb.internal.bulk.DeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TaskManagerServiceImpl implements TaskManagerService {

    @Autowired
    private TaskManagerRepository taskManagerRepository;
    @Autowired
    private TaskService taskService;


    public TaskManager createTaskManager(User user){
        if (taskManagerRepository.findTodoListByUserEmail(user.getEmail()).isEmpty()){
            TaskManager taskManager = new TaskManager();
            taskManager.setUser(user);
            this.taskManagerRepository.save(taskManager);
            return taskManager;
        }
        return taskManagerRepository.findById(user.getEmail()).orElseThrow();
    }



    @Override
    public ArrayList<Task> viewAllTasks(User user) {
        TaskManager taskManager = findTaskManagerByUser(user);
        return taskManager.getTasks();
    }
    @Override
    public ArrayList<Task> deleteTasks(DeleteATaskRequest deleteATaskRequest) {
        TaskManager taskManager = findTaskManagerByUser(deleteATaskRequest.getUser());
        taskManager.getTasks().remove(deleteATaskRequest.getTask());
        taskManagerRepository.save(taskManager);
        return taskManager.getTasks();
    }

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest){
        Task task =  taskService.createTask(createTaskRequest);
        TaskManager taskManager = findTaskManagerByUser(createTaskRequest.getUser());
        ArrayList<Task> tasks = viewAllTasks(createTaskRequest.getUser());
        tasks.add(task);
        taskManager.setTasks(tasks);
        this.taskManagerRepository.save(taskManager);
        return task;
    };



    @Override
    public TaskManager findTaskManagerByUser(User user){
        return taskManagerRepository.findTaskManagerByUser(user).orElseThrow();
    }
}
