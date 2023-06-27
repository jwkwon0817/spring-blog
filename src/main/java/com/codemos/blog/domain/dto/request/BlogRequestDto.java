package com.codemos.blog.domain.dto.request;

import com.codemos.blog.domain.entities.Blog;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class BlogRequestDto {
	
	private String author;
	private String title;
	private String content;
	
	
	public Blog toEntity() {
		return Blog.builder()
			.author(author)
			.title(title)
			.content(content)
			.build();
	}
}
