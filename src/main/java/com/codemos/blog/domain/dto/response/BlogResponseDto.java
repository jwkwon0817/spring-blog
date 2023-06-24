package com.codemos.blog.domain.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class BlogResponseDto {
	
	private final Integer id;
	private final String title;
	
	private final String content;
	private final LocalDateTime createdDate;
}
