package com.mec.mundoDisney.exception;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<?> noSuchElementException(HttpServletRequest request, NoSuchElementException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<?> emptyResultDataAccessException(HttpServletRequest request,
			EmptyResultDataAccessException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(HttpServletRequest request,
			EmptyResultDataAccessException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
