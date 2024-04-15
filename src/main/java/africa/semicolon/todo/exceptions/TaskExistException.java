package africa.semicolon.todo.exceptions;

public class TaskExistException extends TodoListException{
    public TaskExistException(String message) {
        super(message);
    }
}
