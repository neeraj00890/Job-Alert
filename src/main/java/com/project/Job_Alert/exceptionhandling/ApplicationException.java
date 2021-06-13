package com.project.Job_Alert.exceptionhandling;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApplicationException  extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String message;
	String path;
	HttpStatus statusCode;
	Date timeStamp = new Date();
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 
	 */
	
	
	public ApplicationException() {
	 super();	
	}
	
	public ApplicationException(String message) {
		 super(message);	
		this.message = message;
	}
	
	public ApplicationException(String message, HttpStatus code) {
		 super(message);	
		this.message = message;
		this.statusCode = code;
	}
	
	public ApplicationException(String message, HttpStatus code, String path) {
		 super(message);	
		this.message = message;
		this.statusCode = code;
		this.path = path;
	}
}
