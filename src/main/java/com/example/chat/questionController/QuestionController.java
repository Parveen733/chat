package com.example.chat.questionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.chat.Application;


@Controller
public class QuestionController {
	@RequestMapping("/setQuestion")
	public String home() {
		return "NewFile";
	}
	
	@RequestMapping("/setQuestions")
	public String insertQ(@RequestParam String question, @RequestParam String answer) {
		System.out.println("started");
		Application.saveQusetion(question,answer);
		return "NewFile";
	}
}
