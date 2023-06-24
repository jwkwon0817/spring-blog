package com.codemos.blog.web.controllers;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import com.codemos.blog.domain.dto.response.BlogResponseDto;
import com.codemos.blog.domain.exceptions.BlogNotFoundException;
import com.codemos.blog.domain.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blog")
@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/create")
	public BlogResponseDto createBlog(@RequestBody BlogRequestDto blogDto) throws Exception {
		return blogService.create(blogDto);
	}
	
	@PostMapping("/update/{id}")
	public BlogResponseDto updateBlog(@PathVariable Integer id, @RequestBody BlogRequestDto blogDto) throws Exception {
		return blogService.update(id, blogDto);
	}
	
	@PostMapping("/delete/{id}")
	public void deleteBlog(@PathVariable Integer id) throws Exception {
		blogService.delete(id);
	}
	
	@PostMapping("/{id}")
	public BlogResponseDto findBlog(@PathVariable Integer id) throws Exception {
		return blogService.findById(id);
	}
	
	@PostMapping
	public List<BlogResponseDto> findAllBlogs() throws Exception {
		return blogService.findAll();
	}
	
	@ExceptionHandler(BlogNotFoundException.class)
	public String handleQuestionNotFoundException(BlogNotFoundException e) {
		return e.getMessage();
	}
}
