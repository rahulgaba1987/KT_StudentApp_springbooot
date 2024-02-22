package com.boot.exception;

public class ApiResponse
{
	private String message;
	private String response;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", response=" + response + "]";
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
