//package africa.semicolon.todo.utils;
//
//import africa.semicolon.todo.data.model.Task;
//import africa.semicolon.todo.data.model.TodoList;
//import africa.semicolon.todo.dtos.requests.CreateTaskRequest;
//import africa.semicolon.todo.dtos.requests.CreateTodoRequest;
//import africa.semicolon.todo.dtos.requests.RegisterRequest;
//import africa.semicolon.todo.dtos.responses.TaskResponse;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//public class Mapper {
//    public static Task map(CreateTaskRequest taskRequest) {
//        Task task = new Task();
//        task.setUsername(taskRequest.getUsername());
//        task.setMessage(taskRequest.getMessage());
//        task.setTodoId(taskRequest.getTodoId());
//        task.setCreatedAt(LocalDateTime.now());
//        task.setId(task.getId());
//        return task;
//    }
//
//    public static TaskResponse map(Task task) {
//        TaskResponse response = new TaskResponse();
//        response.setMessage(task.getMessage());
//        response.setDescription(task.getDescription());
//        response.setCreatedAt(task.getCreatedAt());
//        response.setId(task.getId());
//        response.setTodoId(task.getTodoId());
//        response.setTimeDone(task.getTimeDone());
//        return response;
//    }
//
//    public static TodoList map(CreateTodoRequest todoRequest) {
//        TodoList todoList = new TodoList();
//        todoList.setTitle(todoRequest.getTitle());
//        return todoList;
//    }
//
//    public static TodoResponse map(TodoList todoList) {
//        TodoResponse response = new TodoResponse();
//        response.setTitle(todoList.getTitle());
//        response.setMessage("TodoList Successfully Created");
//        response.setId(todoList.getId());
//        return response;
//    }
//
//    public static TodoList mapToTodolist(RegisterRequest registerRequest) {
//        TodoList todoList = new TodoList();
//        todoList.setId(todoList.getId());
//        todoList.setTitle(todoList.getTitle());
//        todoList.setUsername(todoList.getUsername());
//        todoList.setPassword(todoList.getPassword());
//        todoList.setLogOut(todoList.isLogOut());
//        todoList.setRole(todoList.getRole());
//        return todoList;
//    }
//
//    public static Task mapDataToTask(DataRequest dataRequest, String id) {
//        Task task = new Task();
//        task.setMessage(dataRequest.getMessage());
//        task.setLocalDate(dataRequest.getDate());
//        task.setDueDateTime(dataRequest.getDueDateTime());
//        task.setTodoId(id);
//        return task;
//    }
//
//    public static LocalDate mapDateToLocalDate(Date date) {
//        return LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
//    }
//}