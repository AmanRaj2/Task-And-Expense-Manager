package com.learning.TodoApp.repository;

import com.learning.TodoApp.entity.Kharcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KharchaRepo extends JpaRepository<Kharcha,Integer> {
}
