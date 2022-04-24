package com.noah.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandeler {
	//加入數字 exception處理
		@ExceptionHandler
		public ResponseEntity<StudentNotFoundResponse> handleException(StudentNotFoundException e){
			
			StudentNotFoundResponse studentNotFoundResponse =
					new StudentNotFoundResponse();
			studentNotFoundResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentNotFoundResponse.setMessage("Not Found");
			studentNotFoundResponse.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(studentNotFoundResponse,HttpStatus.NOT_FOUND);		
		}//加入字母 處理
		@ExceptionHandler
		public ResponseEntity<StudentNotFoundResponse> handleException(Exception e){
			StudentNotFoundResponse studentNotFoundResponse =
					new StudentNotFoundResponse();
			studentNotFoundResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			studentNotFoundResponse.setMessage(e.getMessage());
			studentNotFoundResponse.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(studentNotFoundResponse,HttpStatus.BAD_REQUEST);		
		}
}
