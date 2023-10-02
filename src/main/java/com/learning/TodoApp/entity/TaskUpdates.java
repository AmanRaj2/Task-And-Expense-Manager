package com.learning.TodoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TaskUpdates implements Comparable<TaskUpdates>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastUpdate;
    private Date lastUpdateDate;

    public TaskUpdates(String note, Date date) {
        lastUpdate = note;
        lastUpdateDate = date;
    }

    @Override
    public int compareTo(TaskUpdates o) {
        return (int) (o.id - this.id);
    }
}
