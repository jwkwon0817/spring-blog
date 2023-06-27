package com.codemos.blog.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class BlogResponseDto {
	
	private Long id;
	private String author;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	
}
