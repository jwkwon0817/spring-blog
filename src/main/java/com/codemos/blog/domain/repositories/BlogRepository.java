package com.codemos.blog.domain.repositories;

import com.codemos.blog.domain.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	
	List<Blog> findByAuthor(String author);
	
	List<Blog> findByTitleContaining(String title);
}
