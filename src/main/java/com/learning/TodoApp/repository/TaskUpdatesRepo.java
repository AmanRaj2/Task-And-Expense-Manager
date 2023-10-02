package com.learning.TodoApp.repository;

import com.learning.TodoApp.entity.TaskUpdates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskUpdatesRepo extends JpaRepository<TaskUpdates,Long> {
}
