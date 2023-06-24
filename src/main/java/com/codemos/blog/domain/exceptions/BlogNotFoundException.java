package com.codemos.blog.domain.exceptions;

public class BlogNotFoundException extends RuntimeException {
	
	public BlogNotFoundException(String message) {
		super(message);
	}
}
