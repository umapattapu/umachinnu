package com.store.ram.util;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.store.ram.exception.RamStoreException;




@RestControllerAdvice
public class EventRegistationExController {

	@Autowired
	private Environment environment;
	//----------handling bad request
	@ExceptionHandler(RamStoreException.class)
	public ResponseEntity<ErrorInfo> handle400(RamStoreException exception){
		ErrorInfo errorInfo=new ErrorInfo();
	
		errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setTimeStamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}
	
	//----------handling any others error
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorInfo> genericHandler(Exception exception){
//		ErrorInfo errorInfo=new ErrorInfo();
//	
//		errorInfo.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
//		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//		errorInfo.setTimeStamp(LocalDateTime.now());
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
//	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> validationHandler(Exception exception){
		ErrorInfo errorInfo=new ErrorInfo();
	
		String errorMessage=null;
		if(exception instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException ex=(MethodArgumentNotValidException) exception;
		 errorMessage = ex.getAllErrors().stream()
				.map(e-> e.getDefaultMessage())
				.collect(Collectors.joining(","));
		}else {
			errorMessage=exception.getMessage();
			//errorMessage=environment.getProperty(errorMessage);
		}
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setTimeStamp(LocalDateTime.now());
		errorInfo.setErrorMessage(errorMessage);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}
	
}
