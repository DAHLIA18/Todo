package africa.semicolon.todo.services;

import africa.semicolon.todo.data.model.Work;
import africa.semicolon.todo.data.repositories.WorkRepository;
import africa.semicolon.todo.dtos.requests.CreateWorkRequest;
import africa.semicolon.todo.dtos.requests.UpdateWorkRequest;
import africa.semicolon.todo.dtos.responses.WorkResponse;
import africa.semicolon.todo.exceptions.WorkNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class WorkServiceImpl implements WorkService{

    private  WorkRepository workRepository;

    @Override
    public String getWorkByTitle(String title) {
        workRepository.findByTitle(title);
        return title;
    }

    @Override
    public List<Work> getAllWork() {
        return workRepository.findAll();
    }

    @Override
    public WorkResponse updateTask(UpdateWorkRequest work) {
        Work updateWork = workRepository.findByTitle(work.getTitle());
        if (work.getTitle()!= null && work.getDescription() != null && work.getTodoId() != null){
            updateWork.setTitle(work.getNewTitle());
            updateWork.setTodoId(work.getTodoId());
            updateWork.setDescription(work.getNewDescription());
        }
        Work savedWork = workRepository.save(updateWork);
        WorkResponse workResponse = new WorkResponse();
        workResponse.setTitle(savedWork.getTitle());
        workResponse.setTodoId(savedWork.getTodoId());
        workResponse.setDescription(savedWork.getDescription());
        return workResponse;
    }

    @Override
    public String deleteWork(CreateWorkRequest request) {
        Work foundWork = workRepository.findByTitle(deleteWorkRequest.getTitle());

        if (foundWork != null){
            workRepository.delete(foundWork);
            return "Task Successfully Deleted";
        }
        throw new WorkNotFoundException("Work Not found");

        return null;
    }

    @Override
    public long getCountOfTask() {
        return workRepository.count();
    }

    @Override
    public String workDone(Work work) {
        work.setStatus(true);
        work.setTimeDone(LocalDateTime.now());
        return "successful";

    }

    @Override
    public void deleteTask(Work work) {
        Work foundTask = workRepository.findByTitle(work.getTitle());
        workRepository.deleteByTitle(foundTask.getTitle());
    }

    @Override
    public void deleteAll() {
        workRepository.deleteAll();
    }
    @Override
    public Work findByTitle(String title) {
        return workRepository.findByTitle(title);
    }

    @Override
    public Work save(Work newWork) {
        return workRepository.save(newWork);
    }
}
