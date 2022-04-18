package com.example.chat;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.chat.question.Question;
import com.example.chat.questiondao.QuestionRepository;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication

public class Application extends SpringBootServletInitializer {

	public static ApplicationContext context;
	public static void main(String[] args) {
		
		context=SpringApplication.run(Application.class, args);

    }
	public static Question saveQusetion(String q,String a) {
		QuestionRepository questionRepository= context.getBean(QuestionRepository.class);
		Question qst=new Question();
		qst.setQuestion(q);
		qst.setAnswer(a);
		
		
		Question user1 = questionRepository.save(qst);
		System.out.println("success");
		return user1;
	}
	

	public static List<Question> getQusetion(String q) {
		QuestionRepository questionRepository= context.getBean(QuestionRepository.class);

		List<Question> user1 = questionRepository.findByQuestionCon(q);
		if(user1.isEmpty()) {
			
			Question que=new Question();
			que.setQuestion(q);
			que.setAnswer("Wrong Question");
			user1.add(que);
		}
		

		
		return user1;
	}
	  

	

    @Bean
    public ScheduledExecutorService executorService() {
        return Executors.newScheduledThreadPool(2);
    }
	

}
