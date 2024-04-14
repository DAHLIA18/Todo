package africa.semicolon.todo.data.repositories;

import africa.semicolon.todo.data.model.Work;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkRepository extends MongoRepository <Work, String> {
    Work findByTitle(String title);
    void deleteByTitle(String string);

}
