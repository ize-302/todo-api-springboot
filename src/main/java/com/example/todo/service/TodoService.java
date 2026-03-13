package com.example.todo.service;

import java.util.List;

import com.example.todo.dto.CreateTodoDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.dto.UpdateTodoDto;
import com.example.todo.entity.Todo;

public interface TodoService {
	Todo createTodo(CreateTodoDto todo);

	List<TodoResponseDto> getTodos();

	TodoResponseDto getTodo(Integer id);

	Todo updateTodo(Integer id, UpdateTodoDto todo);

	void deleteTodo(Integer id);

}
