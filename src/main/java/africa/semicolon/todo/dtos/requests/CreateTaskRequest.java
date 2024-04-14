package africa.semicolon.todo.dtos.requests;
import lombok.Data;

import java.util.Date;

@Data
public class CreateRequest {
    private String title;
    private String Username;
    private String message;
    private String todoId;
}
