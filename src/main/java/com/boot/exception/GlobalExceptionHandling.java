package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling 
{

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>  handleResourceNotFound(ResourceNotFoundException  ex)
	{
		 String message = ex.getMsg();
		 
		 ApiResponse  obj = new ApiResponse();
		 obj.setMessage(message);
		 obj.setResponse("Resource_Not_Found");
		return new ResponseEntity<ApiResponse>(obj,HttpStatus.NOT_FOUND);
	}
	
}
