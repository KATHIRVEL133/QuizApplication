package com.springbootpractice.quizApplication.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootpractice.quizApplication.dao.QuestionDao;
import com.springbootpractice.quizApplication.dao.QuizDao;
import com.springbootpractice.quizApplication.model.QuestionWrapper;
import com.springbootpractice.quizApplication.model.Questions;
import com.springbootpractice.quizApplication.model.Quiz;

@Service
public class QuizService {

    @Autowired
    QuestionDao quesDao;
    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> createQuiz(String title, String category, int numQ) {
      try
      {
          Quiz q = new Quiz();
          List<Questions> listOfQues = quizDao.findRandomQuestionsByCategory(category,numQ);
          q.setTitle(title);
          q.setCategory(category);
          q.setQuestions(listOfQues);
          quizDao.save(q);
          return new ResponseEntity<>("Quiz Successfully Created",HttpStatus.OK);
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      return new ResponseEntity<>("Quiz failed to create",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try
        {
            Optional<Quiz> q = quizDao.findById(id);
            List<Questions> questionsDB = q.get().getQuestions();
            List<QuestionWrapper> qWrappers = new ArrayList<>();
            for(Questions q1 : questionsDB)
            {
            QuestionWrapper qw = new QuestionWrapper(q1.getId(), q1.getQuestionTitle(), q1.getOption1(),q1.getOption2(), q1.getOption3(),q1.getOption4());
            qWrappers.add(qw);
            }
            return new ResponseEntity<>(qWrappers,HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

}
