package com.springbootpractice.quizApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpractice.quizApplication.model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Long> {
  List<Questions> findByCategory(String category);
}
