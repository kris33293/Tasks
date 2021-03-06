package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTask(Long taskId){
       return repository.findTaskById(taskId);
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public void deleteTaskBy(Long taskId){
        repository.deleteById(taskId);
    }

    public void deleteALl(){
        repository.deleteAll();
    }
}