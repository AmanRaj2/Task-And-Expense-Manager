package com.learning.TodoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TODO_TASKS")
public class ToDoTask implements Comparable<ToDoTask>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;
    private Date createdOn;
    private Date updatedOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private List<TaskUpdates> taskUpdates = new ArrayList<>();

    @Override
    public int compareTo(ToDoTask o) {
        if(priority!=o.getPriority()){
            return priorityOrder(o.getPriority()) - priorityOrder(priority);
        }
        if(createdOn.before(o.getCreatedOn())){
            return -1;
        }
        else{
            return 1;
        }
    }

    public int priorityOrder(TaskPriority priority){
        if(priority == TaskPriority.HIGH){
            return 3;
        }
        else if(priority == TaskPriority.MEDIUM){
            return 2;
        }
        else{
            return 1;
        }
    }
}
