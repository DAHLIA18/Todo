package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.model.TodoList;
import africa.semicolon.todo.data.repositories.TodoListRepository;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TodoListServiceImpl implements TodoListService{
    private final TodoList todoList;
    @Autowired
    private TodoListRepository todoListRepository;
    @Autowired
    private TaskService taskService;

    public TodoListServiceImpl() {
        todoList = new TodoList();
    }
    @Override
    public boolean isLocked() {
        return !todoList.isLogOut();
    }

    @Override
    public ArrayList<Task> tasks() {
        return todoList.getTasks();
    }

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        todoList.setUser(createTaskRequest.getUser());
        Task task =  taskService.createTask(createTaskRequest);
        ArrayList<Task> tasks = todoList.getTasks();
        tasks.add(task);
        todoList.setTasks(tasks);
        todoListRepository.save(todoList);
        return task;
    }
    @Override
    public TodoList todo() {
        return todoList;
    }
}
