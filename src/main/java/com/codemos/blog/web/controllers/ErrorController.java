package com.codemos.blog.web.controllers;

import com.codemos.blog.domain.dto.response.ErrorResponseDto;
import com.codemos.blog.domain.exceptions.BlogNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleQuestionNotFoundException(BlogNotFoundException e) {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage());
		return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
	}
}
