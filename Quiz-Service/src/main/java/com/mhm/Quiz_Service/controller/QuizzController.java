package com.mhm.Quiz_Service.controller;


import com.mhm.Quiz_Service.model.QuestionWrapper;
import com.mhm.Quiz_Service.model.QuizDto;
import com.mhm.Quiz_Service.model.Response;
import com.mhm.Quiz_Service.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizzController {

    @Autowired
    QuizzService quizzService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizzService.createQuizz(quizDto.getCategory(),quizDto.getNumQ(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable int id){
        return quizzService.getQuizById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
        return quizzService.getResult(id,responses);
    }
}
