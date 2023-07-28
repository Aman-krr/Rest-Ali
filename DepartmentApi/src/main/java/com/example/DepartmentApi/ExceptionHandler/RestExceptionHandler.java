package com.example.DepartmentApi.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.DepartmentApi.Exception.DepartmentNotFoundException;
import com.example.DepartmentApi.entity.ErrorBody;

@RestControllerAdvice
@ResponseStatus
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorBody> handleDeptNotFound(DepartmentNotFoundException ex, WebRequest web) {

		ErrorBody body = new ErrorBody(ex.getMessage(),HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

}
