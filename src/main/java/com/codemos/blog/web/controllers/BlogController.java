package com.codemos.blog.web.controllers;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import com.codemos.blog.domain.dto.response.BlogResponseDto;
import com.codemos.blog.domain.services.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blog")
@RestController
@Slf4j
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/create")
	public ResponseEntity<BlogResponseDto> createBlog(@RequestBody BlogRequestDto blogDto) throws Exception {
		return new ResponseEntity<>(blogService.create(blogDto), HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<BlogResponseDto> updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogDto) throws Exception {
		return new ResponseEntity<>(blogService.update(id, blogDto), HttpStatus.OK);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteBlog(@PathVariable Long id) throws Exception {
		blogService.delete(id);
		
		return new ResponseEntity<>("Blog deleted successfully", HttpStatus.OK);
	}
	
	@PostMapping("/find/id/{id}")
	public ResponseEntity<BlogResponseDto> findBlogById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/find/author/{author}")
	public ResponseEntity<List<BlogResponseDto>> findBlogByAuthor(@PathVariable String author) throws Exception {
		return new ResponseEntity<>(blogService.findByAuthor(author), HttpStatus.OK);
		
	}
	
	@PostMapping("/find/title/{title}")
	public ResponseEntity<List<BlogResponseDto>> findBlogByTitle(@PathVariable String title) throws Exception {
		return new ResponseEntity<>(blogService.findByTitleContaining(title), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<List<BlogResponseDto>> findAllBlogs() throws Exception {
		return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
	}
}
