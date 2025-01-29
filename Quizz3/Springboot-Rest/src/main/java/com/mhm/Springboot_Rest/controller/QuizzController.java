package com.mhm.Springboot_Rest.controller;

import com.mhm.Springboot_Rest.model.Question;
import com.mhm.Springboot_Rest.model.QuestionWrapper;
import com.mhm.Springboot_Rest.model.Quizz;
import com.mhm.Springboot_Rest.model.Response;
import com.mhm.Springboot_Rest.service.QuizzService;
import com.mhm.Springboot_Rest.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizzController {

    @Autowired
    QuizzService quizzService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizzService.createQuizz(category,numQ,title);
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
