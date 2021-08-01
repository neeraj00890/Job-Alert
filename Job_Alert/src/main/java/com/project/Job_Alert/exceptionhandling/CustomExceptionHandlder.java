package com.project.Job_Alert.exceptionhandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

@RestControllerAdvice
public class CustomExceptionHandlder {

	/**
	 * Provides handling for exceptions throughout this service.
	 * 
	 * @throws IOException
	 */
	private Gson gson = new Gson();

	@ExceptionHandler(Exception.class)
	public final void handleException(Exception ex, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/json");
		ErrorResponse err = null;
		if (ex instanceof ApplicationException) {
			ApplicationException applicationException = (ApplicationException) ex;
			err = new ErrorResponse(request.getRequestURI(), applicationException.getMessage(), applicationException.getStatusCode().value());
			response.setStatus(applicationException.getStatusCode().value());
		} else {
			err = new ErrorResponse(request.getRequestURI(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(gson.toJson(err));
		pw.flush();
	}

}