package com.capgemini.onlinetestmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.onlinetestmanagement.exception.ErrorInfo;
import com.capgemini.onlinetestmanagement.exception.CategoryException;

@RestControllerAdvice
public class CategoryAdvice {
	
		@ExceptionHandler(value = {CategoryException.class})
		@ResponseStatus(code=HttpStatus.BAD_REQUEST)
		public ErrorInfo handleException1(Exception ex) {
			return new ErrorInfo(ex.getMessage());
		}

}
