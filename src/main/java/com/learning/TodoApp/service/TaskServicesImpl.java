package com.learning.TodoApp.service;

import com.learning.TodoApp.dto.ToDoTaskWrapper;
import com.learning.TodoApp.entity.TaskUpdates;
import com.learning.TodoApp.entity.ToDoTask;
import com.learning.TodoApp.repository.TaskRepo;
import com.learning.TodoApp.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServicesImpl implements TaskServices{
    @Autowired
    TaskRepo taskRepo;
    @Override
    public void addTask(ToDoTask task) {
        task.setCreatedOn(Calendar.getInstance().getTime());
        taskRepo.save(task);
    }

    @Override
    public void updateTask(ToDoTaskWrapper taskWrapper) {
        Optional<ToDoTask> toDoTask = getTaskById(taskWrapper.getToDoTask().getId());
        if(toDoTask.isPresent()){
            taskWrapper.getToDoTask().setCreatedOn(toDoTask.get().getCreatedOn());
            taskWrapper.getToDoTask().setTaskUpdates(toDoTask.get().getTaskUpdates());
        }
        Date date = Calendar.getInstance().getTime();
        taskWrapper.getToDoTask().setUpdatedOn(date);
        if(taskWrapper.getNote() != null && taskWrapper.getNote().length() != 0){
            TaskUpdates taskUpdates = new TaskUpdates(taskWrapper.getNote(),date);
            taskWrapper.getToDoTask().getTaskUpdates().add(taskUpdates);
        }
        taskRepo.save(taskWrapper.getToDoTask());
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepo.deleteById(id);
    }

    @Override
    public List<ToDoTask> getAllTask() {
        List<ToDoTask> list = taskRepo.findAll();
        return list;
    }

    @Override
    public List<ToDoTask> getTaskByTitle(String title) {
        return taskRepo.findByTitle(title);
    }

    @Override
    public Optional<ToDoTask> getTaskById(Integer id) {
        return taskRepo.findById(id);
    }

    @Override
    public List<ToDoTask> getAllCompletedTasksTask() {
        List<ToDoTask> list = getAllTask();
        Collections.sort(list, new ComparatorByUpdatedDate());
        List<ToDoTask> completedTaskList = Utility.filterCompletedTask(list);
        return completedTaskList;
    }

    @Override
    public List<ToDoTask> getAllIncompleteTask() {
        List<ToDoTask> list = getAllTask();
        Collections.sort(list);
        List<ToDoTask> notCompletesTaskList = Utility.filterNotCompleted(list);
        return notCompletesTaskList;
    }

    @Override
    public ToDoTaskWrapper getTaskWrapperById(Integer id) {
        Optional<ToDoTask> task = taskRepo.findById(id);
        ToDoTaskWrapper wrapperTask = new ToDoTaskWrapper();
        if(task.isPresent()){
            wrapperTask.setToDoTask(task.get());
        }
        Collections.sort(wrapperTask.getToDoTask().getTaskUpdates());
        return wrapperTask;
    }

    public static class ComparatorByUpdatedDate implements Comparator<ToDoTask>{
        @Override
        public int compare(ToDoTask o1, ToDoTask o2) {
            if(o1.getUpdatedOn() == null || o2.getUpdatedOn() == null){
                return 0;
            }
            if(o1.getUpdatedOn().before(o2.getUpdatedOn())){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
