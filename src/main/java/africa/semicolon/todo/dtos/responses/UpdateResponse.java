package africa.semicolon.todo.dtos.responses;

import africa.semicolon.todo.utils.Date;
import lombok.Data;

@Data
public class UpdateResponse {
   private String todoId;
   private Date dateCreated;
   private String oldDetails;
   private Date newDueDate;
}
