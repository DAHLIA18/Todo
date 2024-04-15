package africa.semicolon.todo.dtos.requests;
import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.utils.Date;
import africa.semicolon.todo.utils.DateTime;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskRequest {
    private String id;
    private String title;
    private String details;
    private LocalDateTime reminder;
    private User user;
}
