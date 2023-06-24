package com.codemos.blog.domain.repositories;

import com.codemos.blog.domain.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	Blog findByTitle(String title);
	
	Blog findByTitleAndContent(String title, String content);
	
	Blog findByTitleLike(String title);
}
