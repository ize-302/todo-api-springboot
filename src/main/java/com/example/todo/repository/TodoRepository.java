package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository
		extends CrudRepository<Todo, Integer> {
}
