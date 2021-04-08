package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTest {

    @Autowired
    DbService dbService;

    @Test
    void saveTaskTest(){
        //Given
        Task task = new Task();
        Long id = 1L;
        task.setId(id);
        task.setContent("Content");
        task.setTitle("Title");

        //When
        dbService.saveTask(task);
        List<Task> expected = dbService.getAllTasks();

        //Then
        Assertions.assertEquals(expected.get(expected.size()-1).getTitle(),task.getTitle());

        //Cleanup
        dbService.deleteALl();
    }

    @Test
    void getAllTasksTest(){
        //Given
        Task task = new Task();
        task.setContent("Content");
        task.setTitle("Title");

        Task task2 = new Task();

        task2.setContent("Content2");
        task2.setTitle("Title2");

        //When
        dbService.saveTask(task);
        dbService.saveTask(task2);
        List<Task> expected = dbService.getAllTasks();

        //Then
        Assertions.assertEquals(expected.get(expected.size()-2).getTitle(),task2.getTitle());
        Assertions.assertEquals(expected.get(expected.size()-1).getTitle(),task.getTitle());

        //Cleanup
        dbService.deleteALl();
    }

    @Test
    void deleteTaskTest(){
        //Given
        Task task = new Task();
        task.setContent("Content");
        task.setTitle("Title");
        dbService.saveTask(task);
        Long id = dbService.getAllTasks().get(0).getId();
        //When

        dbService.deleteTaskBy(id);

        //Then
        Assertions.assertNull(dbService.getTask(id));

        //Cleanup
        dbService.deleteALl();
    }




}