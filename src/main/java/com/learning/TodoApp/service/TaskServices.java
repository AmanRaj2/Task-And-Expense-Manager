package com.learning.TodoApp.service;

import com.learning.TodoApp.dto.ToDoTaskWrapper;
import com.learning.TodoApp.entity.ToDoTask;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskServices {
    void addTask(ToDoTask task);
    void updateTask(ToDoTaskWrapper task);
    void deleteTask(Integer id);
    List<ToDoTask> getAllTask();
    List<ToDoTask> getTaskByTitle(String title);
    Optional<ToDoTask> getTaskById(Integer id);

    List<ToDoTask> getAllCompletedTasksTask();

    List<ToDoTask> getAllIncompleteTask();

    ToDoTaskWrapper getTaskWrapperById(Integer id);
}
