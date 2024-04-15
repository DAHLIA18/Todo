package africa.semicolon.todo.exceptions;

public class UserExistException extends TodoListException{

    public UserExistException(String message) {
        super(message);
    }
}
