package africa.semicolon.todo.dtos.requests;

import lombok.Data;

@Data
public class CreateTodoRequest {
    private String task;
    private String todo;
    private String message;
    }
