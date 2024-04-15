package africa.semicolon.todo.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Task {
    @Id
    private String id;
    private String title;
    private String details;
    private  LocalDateTime reminder;
}
