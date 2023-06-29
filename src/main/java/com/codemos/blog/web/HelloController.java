package com.codemos.blog.web;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/test")
	public BlogRequestDto index() {
		return new BlogRequestDto("author", "title", "content");
	}
}
