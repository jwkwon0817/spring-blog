package com.codemos.blog.domain.services;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import com.codemos.blog.domain.dto.response.BlogResponseDto;

import java.util.List;

public interface BlogService {
	
	BlogResponseDto create(BlogRequestDto blogDto) throws Exception;
	
	BlogResponseDto update(Integer id, BlogRequestDto blogDto) throws Exception;
	
	void delete(Integer id) throws Exception;
	
	BlogResponseDto findById(Integer id) throws Exception;
	
	List<BlogResponseDto> findAll() throws Exception;
}
