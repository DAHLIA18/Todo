package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.data.repositories.UserRepository;
import africa.semicolon.todo.dtos.requests.RegisterRequest;
import africa.semicolon.todo.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;




    @Override
    public User registerUser(RegisterRequest registerRequest) {
          if (userRepository.findByEmail(registerRequest.getEmail()).isEmpty()) {
              User user = new User();
              user.setEmail(registerRequest.getEmail());
              user.setPassword(registerRequest.getPassword());
              userRepository.save(user);
              return user;
          }
          throw new UserExistException("Username already exists");

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User findUser(User user){
        return findUserById(user.getId());
    }
    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow();
    }
}