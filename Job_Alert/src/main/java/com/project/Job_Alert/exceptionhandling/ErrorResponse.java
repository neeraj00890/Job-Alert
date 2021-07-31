package com.project.Job_Alert.exceptionhandling;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	String path;
	String message;
	Date timeStamp = new Date();
	int statusCode;

	public ErrorResponse(String path, String message, int statusCode) {
		this.path = path;
		this.message = message;
		this.statusCode = statusCode;
	}

}
