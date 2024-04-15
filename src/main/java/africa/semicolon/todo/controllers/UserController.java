package africa.semicolon.todo.controllers;

import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.dtos.requests.RegisterRequest;
import africa.semicolon.todo.exceptions.UserExistException;
import africa.semicolon.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            User registeredUser = userService.registerUser(registerRequest);
            return ResponseEntity.ok(registeredUser);
        } catch (UserExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("failed to register user"+ e.getMessage());
        }
    }
}
