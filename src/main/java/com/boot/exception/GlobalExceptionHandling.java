package com.boot.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;

import jakarta.validation.UnexpectedTypeException;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<Map<String,String>> handleUnexpectedTypeException(MethodArgumentNotValidException ex)
	{
		System.out.println(ex);
		Map<String,String> resp= new HashMap<>();
		
		
		 ex.getBindingResult().getAllErrors().forEach((error)->
		{
			String message= error.getDefaultMessage();
			String fieldName= ((FieldError)error).getField();
			resp.put(fieldName, message);
			
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.NOT_FOUND);
		
	}
	
}
