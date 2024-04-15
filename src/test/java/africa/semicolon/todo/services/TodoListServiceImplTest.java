package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.data.repositories.TaskRepository;
import africa.semicolon.todo.data.repositories.TaskManagerRepository;
import africa.semicolon.todo.data.repositories.UserRepository;
import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
import africa.semicolon.todo.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TodoListServiceImplTest {
    @Autowired
    private TaskManagerRepository taskManagerRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskManagerService taskManagerService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        taskRepository.deleteAll();
        taskManagerRepository.deleteAll();
        userRepository.deleteAll();

    }
    @Test
    public void testThatTodoCanBeAdded(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("ogbanje1@gmail.com");
        registerRequest.setPassword("ogbanje");

       User user = userService.registerUser(registerRequest);

        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTitle("isi mbe");
        createTaskRequest.setDetails("ogbe anya");
        createTaskRequest.setReminder(LocalDateTime.now());
        createTaskRequest.setUser(user);

        taskManagerService.createTaskManager(createTaskRequest.getUser());
        assertNotNull(taskManagerService.createTask(createTaskRequest));
        assertNotNull(taskManagerService.findTaskManagerByUser(createTaskRequest.getUser()));
        assertEquals(1,taskManagerService.viewAllTasks(createTaskRequest.getUser()).size());
        assertEquals(taskManagerRepository.count(),1);

        CreateTaskRequest createTaskRequest1 = new CreateTaskRequest();
        createTaskRequest1.setTitle("isi mbe");
        createTaskRequest1.setDetails("ogbe anya");
        createTaskRequest1.setReminder(LocalDateTime.now());
        createTaskRequest1.setUser(user);
        taskManagerService.createTask(createTaskRequest);
        assertEquals(2,taskManagerService.viewAllTasks(createTaskRequest.getUser()).size());
    }

}