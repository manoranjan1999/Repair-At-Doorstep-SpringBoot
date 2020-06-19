package com.example.repair.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAlreadyExceptionController {
	
	@ExceptionHandler(value = UserAlreadyRegisteredException.class)
	public ResponseEntity<Object> exception(UserAlreadyRegisteredException exception){
		Map<String, String> headers=new HashMap<String, String>();
		headers.put("Status", "400");
		headers.put("Message", "Already Registered");
		headers.put("User", exception.getEmailId());
		
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

}
