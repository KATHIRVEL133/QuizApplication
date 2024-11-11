package com.springbootpractice.quizApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootpractice.quizApplication.dao.QuestionDao;
import com.springbootpractice.quizApplication.model.Questions;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;

    public ResponseEntity<List<Questions>> getAllQuestions()
    {
      try {
        return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> postAllQuestions(Questions q) {
       try
       {
        questiondao.save(q);
        return new ResponseEntity<>("saved Successfully",HttpStatus.CREATED);
       }
       catch(Exception e)
       {
       e.printStackTrace();
       }
       return new ResponseEntity<>("Failed to Save",HttpStatus.BAD_REQUEST);
       
    }
    public ResponseEntity<List<Questions>> findByCategory(String category) {
      try
      {
         return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
   public ResponseEntity<String> deleteAllQuestions() {
       try
       {
         questiondao.deleteAll();
         return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
       return new ResponseEntity<>("Delete Successfull",HttpStatus.BAD_REQUEST);
   }
}
