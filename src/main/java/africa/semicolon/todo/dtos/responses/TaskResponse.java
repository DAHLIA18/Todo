package africa.semicolon.todo.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskResponse {
    private String id;
    private String details;
    private boolean status = false;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime timeDone = LocalDateTime.now();
    private String todoId;
}
