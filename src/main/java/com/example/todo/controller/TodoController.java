package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.CreateTodoDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.dto.UpdateTodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo controller", description = "Simple CRUD operations")
public class TodoController {
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping()
	@Operation(summary = "Create new todo")
	@ApiResponse(responseCode = "201", description = "Item has been created")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true)
	public Todo createTodo(@Valid @RequestBody CreateTodoDto todo) {
		return todoService.createTodo(todo);
	}

	@GetMapping()
	@ApiResponse(responseCode = "200", description = "Fetched list of todo items")
	@Operation(summary = "List out todos")
	public List<TodoResponseDto> getTodos() {
		return todoService.getTodos();
	}

	@GetMapping("{id}")
	@ApiResponse(responseCode = "404", description = "Item not found")
	@Operation(summary = "Get a todo")
	public TodoResponseDto getTodo(@PathVariable Integer id) {
		return todoService.getTodo(id);
	}

	@PatchMapping("{id}")
	@ApiResponse(responseCode = "404", description = "Item not found")
	@Operation(summary = "Update todo")
	public Todo updateTodo(@PathVariable Integer id, @RequestBody UpdateTodoDto todo) {
		return todoService.updateTodo(id, todo);
	}

	@DeleteMapping("{id}")
	@ApiResponse(responseCode = "204", description = "Item has been deleleted")
	@ApiResponse(responseCode = "404", description = "Item not found")
	@Operation(summary = "Delete todo")
	public void deleteTodo(@PathVariable Integer id) {
		todoService.deleteTodo(id);
	}
}
