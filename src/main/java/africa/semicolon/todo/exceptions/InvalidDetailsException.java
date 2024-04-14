package africa.semicolon.todo.exceptions;

public class TaskNotFoundException extends TodoListException {

    public TaskNotFoundException(String message) {
        super(message);
    }
}
