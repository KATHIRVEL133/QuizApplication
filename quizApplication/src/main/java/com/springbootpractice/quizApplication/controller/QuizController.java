package com.springbootpractice.quizApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.quizApplication.model.QuestionWrapper;
import com.springbootpractice.quizApplication.service.QuizService;



@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String title,@RequestParam String category,@RequestParam int numQ)
    {
    return quizService.createQuiz(title,category,numQ);
    }
    @GetMapping("/get")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
    return quizService.getQuizQuestions(id);
    }
}
