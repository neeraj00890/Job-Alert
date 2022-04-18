package com.project.Job_Alert.dto;

public class ResponseDTO {
	String message;
	Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ResponseDTO [message=" + message + ", data=" + data + "]";
	}

}
