package com.learning.TodoApp.controller;

import com.learning.TodoApp.dto.ToDoTaskWrapper;
import com.learning.TodoApp.entity.ToDoTask;
import com.learning.TodoApp.service.TaskServices;
import com.learning.TodoApp.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller

public class IndexController {
    @Autowired
    TaskServices taskServices;

    @GetMapping("/")
    public String home(Model model){
        List<ToDoTask> list = taskServices.getAllIncompleteTask();
        model.addAttribute("taskList",list);
        return "index";
    }

    @GetMapping("/addTask")
    public String addTask(){
        return "addTask";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute ToDoTask toDoTask){
        taskServices.addTask(toDoTask);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id){
        taskServices.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable  Integer id, Model model){
        ToDoTaskWrapper task = taskServices.getTaskWrapperById(id);
        model.addAttribute("task",task);
        return "editTask";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute ToDoTaskWrapper task){
        taskServices.updateTask(task);
        return "redirect:/edit/"+task.getToDoTask().getId();
    }

    @GetMapping("/completedTask")
    public String completedTaskView(Model model){
        List<ToDoTask> list = taskServices.getAllCompletedTasksTask();
        model.addAttribute("taskList",list);
        return "completedTask";
    }


}
