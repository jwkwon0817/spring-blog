package com.codemos.blog.domain.repositories;

import com.codemos.blog.domain.entities.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class QuestionRepositoryTests {
	
	@Autowired
	private BlogRepository questionRepository;
	
	@Test
	void createQuestions() {
		Blog q1 = new Blog();
		q1.setTitle("Subject 1");
		q1.setContent("Content 1");
		q1.setCreateDate(LocalDateTime.now());
		
		Blog q2 = new Blog();
		q2.setTitle("Subject 2");
		q2.setContent("Content 2");
		q2.setCreateDate(LocalDateTime.now());
		
		questionRepository.save(q1);
		questionRepository.save(q2);
	}
	
	@Test
	void findAll() {
		List<Blog> questions = questionRepository.findAll();
		assertEquals(2, questions.size());
		
		Blog q = questions.get(0);
		assertEquals("Subject 1", q.getTitle());
	}
	
	@Test
	void findById() {
		Optional<Blog> optional = questionRepository.findById(1);
		if (optional.isPresent()) {
			Blog q = optional.get();
			assertEquals("Subject 1", q.getTitle());
		}
	}
	
	@Test
	void findBySubject() {
		Blog q = questionRepository.findBySubject("Subject 1");
		assertEquals("Content 1", q.getContent());
	}
	
	@Test
	void findBySubjectAndContent() {
		Blog q = questionRepository.findBySubjectAndContent("Subject 1", "Content 1");
		assertEquals(1, q.getId());
	}
	
	@Test
	void findBySubjectLike() {
		Blog q = questionRepository.findBySubjectLike("Subject%");
		assertEquals(1, q.getId());
	}
	
	@Test
	void updateQuestion() {
		Optional<Blog> optional = this.questionRepository.findById(1);
		assertTrue(optional.isPresent());
		Blog q = optional.get();
		q.setTitle("Updated Subject 1");
		questionRepository.save(q);
	}
	
	@Test
	void deleteQuestion() {
		assertEquals(2, this.questionRepository.count());
		Optional<Blog> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Blog q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}
}
