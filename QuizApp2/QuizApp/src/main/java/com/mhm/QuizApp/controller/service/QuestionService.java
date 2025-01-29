package com.mhm.QuizApp.controller.service;



import com.mhm.QuizApp.controller.model.Question;
import com.mhm.QuizApp.controller.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionnRepo;
    public List<Question> getAllQuestions() {
        return questionnRepo.findAll();
    }
}
