package com.codemos.blog.domain.services;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import com.codemos.blog.domain.dto.response.BlogResponseDto;

import java.util.List;

public interface BlogService {
	
	BlogResponseDto create(BlogRequestDto blogDto) throws Exception;
	
	BlogResponseDto update(Long id, BlogRequestDto blogDto) throws Exception;
	
	void delete(Long id) throws Exception;
	
	BlogResponseDto findById(Long id) throws Exception;
	
	List<BlogResponseDto> findAll() throws Exception;
	
	List<BlogResponseDto> findByAuthor(String author) throws Exception;
	
	List<BlogResponseDto> findByTitleContaining(String title) throws Exception;
}
