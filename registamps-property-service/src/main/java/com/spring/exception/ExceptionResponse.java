package com.spring.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private String message;
	private LocalDateTime dateTime;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
