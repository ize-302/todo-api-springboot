package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.repository.TodoRepository;
import com.example.todo.dto.CreateTodoDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.dto.UpdateTodoDto;
import com.example.todo.entity.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	@Transactional
	public Todo createTodo(CreateTodoDto todo) {
		Todo new_todo = new Todo(null, todo.getTitle(), todo.getNote(), todo.getCompleted());
		return todoRepository.save(new_todo);
	}

	@Override
	public List<TodoResponseDto> getTodos() {
		List<TodoResponseDto> responses = new ArrayList<>();
		todoRepository.findAll().forEach((todo) -> responses.add(new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getNote(), todo.getCompleted())));
		return responses;
	}

	@Override
	public TodoResponseDto getTodo(Integer id) {
		Todo todo = todoRepository.findById(id).get();
		TodoResponseDto response = new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getNote(), todo.getCompleted());
		return response;
	}

	@Override
	@Transactional
	public Todo updateTodo(Integer id, UpdateTodoDto todo) {
		Todo updated_todo = new Todo(null, todo.getTitle(), todo.getNote(), todo.getCompleted());
		return todoRepository.save(updated_todo);
	}

	@Override
	public void deleteTodo(Integer id) {
		todoRepository.deleteById(id);
	}

}
