package africa.semicolon.todo.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("TodoLists")
public class TodoList {
    @Id
    private String id;
    private ArrayList<Task> tasks = new ArrayList<>();
    private boolean isLogOut = true;
    private User user;

}
