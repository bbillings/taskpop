package com.billings.taskpop.repository;

import com.billings.taskpop.model.Task;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TaskRepositoryTest {

    @Test
    public void saveAddsTask () throws Exception {
        TaskRepository taskRepository = new TaskRepository();
        Task task = new Task(1, "Do a Task", "Mow the lawn.");
        taskRepository.saveTask(task);
        assertEquals(Arrays.asList(task), taskRepository.getTasks());
    }

    @Test
    public void removeByIdTakesOutTask () throws Exception {
        TaskRepository taskRepository = new TaskRepository();
        Task task1 = new Task(1, "Do a Task", "Mow the lawn.");
        Task task2 = new Task(2, "A Second Task", "Take out the trash");
        taskRepository.saveTask(task1);
        taskRepository.saveTask(task2);
        taskRepository.removeTaskById(task1.getId());
        assertEquals(Arrays.asList(task2), taskRepository.getTasks());
    }

    @Test
    public void removeByIdReturnsRemovedTask () throws Exception {
        TaskRepository taskRepository = new TaskRepository();
        Task task = new Task(1, "Do a Task", "Mow the lawn.");
        taskRepository.saveTask(task);
        assertEquals(task, taskRepository.removeTaskById(task.getId()));

    }

}