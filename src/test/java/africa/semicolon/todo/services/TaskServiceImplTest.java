package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.repositories.TaskRepository;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskServiceImplTest {
    @Autowired
private TaskRepository taskRepository;
    @Autowired
    private  TaskServiceImpl taskService;

    @BeforeEach
    public  void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    public void testThatTaskCanBeCreated(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTitle("Hello, world!");
        createTaskRequest.setDetails("Hello, world!");
        createTaskRequest.setReminder(LocalDateTime.now());

      Task task =  taskService.createTask(createTaskRequest);
      assertNotNull(task);
      assertEquals(task.getTitle(),"Hello, world!");
    }
}