package com.mkr.todo.repository;

import com.mkr.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {
}
