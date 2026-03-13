package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponseDto {
	private Integer id;

	private String title;

	private String note;

	public TodoResponseDto(Integer id, String title, String note) {
		this.id = id;
		this.title = title;
		this.note = note;
	}
}
