package com.springbootpractice.quizApplication.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.quizApplication.model.Questions;
import com.springbootpractice.quizApplication.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    QuestionService questionService;
    QuestionController(QuestionService questionService)
    {
        this.questionService = questionService;
    }
    @GetMapping("/getQuestions")
    public ResponseEntity<List<Questions>> findAllQuestions()
    {
        return questionService.getAllQuestions();
    }
    @PostMapping("/postQuestions")
    public ResponseEntity<String> postAllQuestions(@RequestBody Questions q)
    {
        return questionService.postAllQuestions(q);
    }
    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<List<Questions>> getByCategory(@PathVariable String category)
    {
     return questionService.findByCategory(category);
    }
    @DeleteMapping("/deleteQuestions")
    public ResponseEntity<String> deleteAllQuestions()
    {
        return questionService.deleteAllQuestions();
    }
}
