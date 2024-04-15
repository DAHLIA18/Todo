package africa.semicolon.todo.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class UpdateRequest {
    private String newTitle;
    private String newDetails;
    private LocalDateTime reminder;
    private String id;
}
