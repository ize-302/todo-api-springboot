package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTodoDto {
	@NotBlank
	private String title;

	private String note;

	public CreateTodoDto(String title, String note) {
		this.title = title;
		this.note = note;
	}

}
