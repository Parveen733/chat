package com.example.chat.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String question;
	@Column(length = 400)
	private String answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		
		return question;
	}
	public void setQuestion(String question) {
		System.out.println(question);
		this.question = question.trim();
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer.trim();
	}
	public Question(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
