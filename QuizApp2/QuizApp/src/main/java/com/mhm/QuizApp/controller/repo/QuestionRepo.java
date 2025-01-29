package com.mhm.QuizApp.controller.repo;

import com.mhm.QuizApp.controller.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    @Query("select q from Question q")
    List<Question> findAll();
}
