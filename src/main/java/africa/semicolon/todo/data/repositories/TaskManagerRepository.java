package africa.semicolon.todo.data.repositories;

import africa.semicolon.todo.data.model.TaskManager;
import africa.semicolon.todo.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoListRepository extends MongoRepository<TaskManager, String> {

    Optional<TaskManager> findTodoListByUserEmail(String email);

    Optional<TaskManager> findTaskManagerByUser(User user);
}
