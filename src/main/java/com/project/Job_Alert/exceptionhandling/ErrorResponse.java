package com.project.Job_Alert.exceptionhandling;

import java.util.Date;

public class ErrorResponse {
	String path;
	String message;
	Date timeStamp = new Date();
	
	public ErrorResponse(String path, String message) {
		this.path = path;
		this.message = message;
	}

}
