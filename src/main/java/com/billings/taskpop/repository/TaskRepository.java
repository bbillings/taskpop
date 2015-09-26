package com.billings.taskpop.repository;

import com.billings.taskpop.model.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<Task>();
    }

    public void saveTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task removeTaskById(Integer id) {
        Iterator<Task> tasksIterator = tasks.iterator();
        Task removedTask = null;
        int taskCounter = 0;
        while(tasksIterator.hasNext()){
            Task task = tasksIterator.next();
            if(task.getId().equals(tasks.get(taskCounter).getId())){
                tasksIterator.remove();
                removedTask = task;
                break;
            }
            taskCounter++;
        }
        return removedTask;
    }
}
