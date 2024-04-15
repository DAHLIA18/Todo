package africa.semicolon.todo.dtos.responses;

import lombok.Data;

@Data
public class TodoResponse {
    private String details;
    private String title;
    private String id;
}
