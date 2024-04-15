package africa.semicolon.todo.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private String id;
    private String email;
    private String password;
}
