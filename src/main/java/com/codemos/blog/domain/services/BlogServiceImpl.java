package com.codemos.blog.domain.services;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import com.codemos.blog.domain.dto.response.BlogResponseDto;
import com.codemos.blog.domain.entities.Blog;
import com.codemos.blog.domain.exceptions.BlogNotFoundException;
import com.codemos.blog.domain.repositories.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class BlogServiceImpl implements BlogService {
	
	private final BlogRepository blogRepository;
	
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	@Override
	public BlogResponseDto create(BlogRequestDto blogDto) throws Exception {
		Blog blog = blogDto.toEntity();
		
		blog = blogRepository.save(blog);
		
		return new BlogResponseDto(blog.getId(), blog.getAuthor(), blog.getTitle(), blog.getContent(), LocalDateTime.now());
	}
	
	@Override
	public BlogResponseDto update(Long id, BlogRequestDto blogDto) {
		Blog blog = blogRepository.findById(id)
			.orElseThrow(() -> new BlogNotFoundException("Blog not found.")); // 예외 처리: 질문을 찾을 수 없을 경우 예외 발생
		
		// 질문 업데이트
		blog.setTitle(blogDto.getTitle());
		blog.setContent(blogDto.getContent());
		
		// 업데이트된 질문 저장
		blog = blogRepository.save(blog);
		
		return new BlogResponseDto(blog.getId(), blog.getAuthor(), blog.getTitle(), blog.getContent(), blog.getCreatedDate());
	}
	
	@Override
	public void delete(Long id) {
		Blog blog = blogRepository.findById(id)
			.orElseThrow(() -> new BlogNotFoundException("Blog not found."));
		
		blogRepository.delete(blog);
	}
	
	@Override
	public BlogResponseDto findById(Long id) {
		Blog blog = blogRepository.findById(id)
			.orElseThrow(() -> new BlogNotFoundException("Blog not found."));
		
		return new BlogResponseDto(blog.getId(), blog.getAuthor(), blog.getTitle(), blog.getContent(), blog.getCreatedDate());
	}
	
	@Override
	public List<BlogResponseDto> findAll() {
		List<Blog> blogs = blogRepository.findAll();
		
		return blogs.stream()
			.map(blog -> new BlogResponseDto(blog.getId(), blog.getAuthor(), blog.getTitle(), blog.getContent(), blog.getCreatedDate()))
			.toList();
	}
	
	@Override
	public List<BlogResponseDto> findByAuthor(String author) {
		List<Blog> blogs = blogRepository.findByAuthor(author);
		
		return blogs.stream()
			.map(blog -> new BlogResponseDto(blog.getId(), blog.getAuthor(), blog.getTitle(), blog.getContent(), blog.getCreatedDate()))
			.toList();
	}
	
	@Override
	public List<BlogResponseDto> findByTitleContaining(String title) {
		List<Blog> blogs = blogRepository.findByTitleContaining(title);
		
		return blogs.stream()
			.map(blog -> new BlogResponseDto(blog.getId(), blog.getAuthor(), blog.getTitle(), blog.getContent(), blog.getCreatedDate()))
			.toList();
	}
}
