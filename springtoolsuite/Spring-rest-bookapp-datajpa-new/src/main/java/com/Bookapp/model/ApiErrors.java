package com.Bookapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrors {

	public ApiErrors(LocalDateTime now, int value, String reason2, String message2) {
		// TODO Auto-generated constructor stub
	}
	private LocalDateTime timestamp;
	private int status;
	private String reason;
	private String message;
}


