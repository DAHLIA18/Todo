package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.dtos.requests.RegisterRequest;

import java.util.Optional;

public interface UserService {
    User registerUser(RegisterRequest registerRequest);
    Optional<User> findByEmail(String email);
    User findUser(User user);
    User findUserById(String id);

}

