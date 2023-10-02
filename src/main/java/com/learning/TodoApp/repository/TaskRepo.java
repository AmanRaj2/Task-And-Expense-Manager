package com.learning.TodoApp.repository;

import com.learning.TodoApp.entity.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<ToDoTask,Integer> {
    List<ToDoTask> findByTitle(String title);
}
