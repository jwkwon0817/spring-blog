package com.codemos.blog.domain.dto;

import com.codemos.blog.domain.dto.request.BlogRequestDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
	
	private Integer id;
	
	private String content;
	
	private LocalDateTime createDate;
	
	private BlogRequestDto question;
}
