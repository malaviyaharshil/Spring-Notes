package com.mhm.QuizApp.controller;

import com.mhm.QuizApp.model.Question;
import com.mhm.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping(path="allQuestions" ,produces = {"application/json"})
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
}
