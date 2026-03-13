package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponseDto {
	private Integer id;

	private String title;

	private String note;

	private Boolean completed;

	public TodoResponseDto(Integer id, String title, String note, Boolean completed) {
		this.id = id;
		this.title = title;
		this.note = note;
		this.completed = completed;
	}
}
