package africa.semicolon.todo.exceptions;

public class UserNotExistException extends TodoListException{
    public UserNotExistException(String message) {
        super(message);
    }
}
