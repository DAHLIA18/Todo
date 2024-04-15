package africa.semicolon.todo.dtos.requests;

import africa.semicolon.todo.data.model.Task;
import africa.semicolon.todo.data.model.User;
import africa.semicolon.todo.utils.Date;
import lombok.Data;



@Data
public class DeleteATaskRequest{
   private User user;
   private Task task;
}
