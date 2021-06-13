package com.project.Job_Alert.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandlder {

	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResponse> handleException(HttpServletRequest req, ApplicationException ex, HttpServletRequest res) {
		ErrorResponse  err = new ErrorResponse(req.getRequestURL().toString(), ex.message);
		return new ResponseEntity<ErrorResponse>(err, ex.getStatusCode());
	}
}
