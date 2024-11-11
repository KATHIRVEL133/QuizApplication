package com.springbootpractice.quizApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbootpractice.quizApplication.model.Questions;
import com.springbootpractice.quizApplication.model.Quiz;


public interface QuizDao extends JpaRepository<Quiz,Integer>{
    
    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ;",nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);

}
