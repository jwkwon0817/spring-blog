package com.codemos.blog.domain.dto.request;

import com.codemos.blog.domain.entities.Blog;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogRequestDto {
	
	private String title;
	
	private String content;
	
	private LocalDateTime createdDate;
	
	public Blog toEntity() {
		return Blog.builder()
			.title(title)
			.content(content)
			.createdDate(createdDate)
			.build();
	}
}
