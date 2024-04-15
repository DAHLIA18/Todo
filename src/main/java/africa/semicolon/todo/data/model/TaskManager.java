package africa.semicolon.todo.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document("TodoLists")
public class TaskManager {
    @Id
    private String id;
    private ArrayList<Task> tasks = new ArrayList<>();
    private boolean isLogOut = true;
    private User user;

}
