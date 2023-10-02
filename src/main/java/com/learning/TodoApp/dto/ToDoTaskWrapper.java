package com.learning.TodoApp.dto;

import com.learning.TodoApp.entity.ToDoTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoTaskWrapper {
    private ToDoTask toDoTask = new ToDoTask();
    private String note;
}
