package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.data.repositories.UserRepository;
import africa.semicolon.todo.dtos.requests.RegisterRequest;
import africa.semicolon.todo.exceptions.UserExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();

    }

    @Test
    public void testThatUserCanBeCreated(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test");
        registerRequest.setPassword("PASSWORD");


    User user =  userService.registerUser(registerRequest);

        assertNotNull( userService.findUserById(user.getId()));


    }

    @Test
    public void testThatUserNameCantBeUsedTwice(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test");
        registerRequest.setPassword("PASSWORD");
        User user =  userService.registerUser(registerRequest);

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setEmail("test");
        registerRequest1.setPassword("PASSWORD");

        assertThrows(UserExistException.class,()->{
            userService.registerUser(registerRequest1);
        });
    }

}