package com.example.chat.questiondao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.chat.question.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer>{

	Question findByQuestion(String q);
	
	@Query(value="select * from question where question LIKE %:q%" , nativeQuery = true)
	public List<Question> findByQuestionCon(@Param("q") String q);
	
}
