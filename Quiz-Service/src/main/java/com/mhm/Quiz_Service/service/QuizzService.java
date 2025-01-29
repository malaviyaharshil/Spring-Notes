package com.mhm.Quiz_Service.service;


import com.mhm.Quiz_Service.QuizzInterface;
import com.mhm.Quiz_Service.model.Question;
import com.mhm.Quiz_Service.model.QuestionWrapper;
import com.mhm.Quiz_Service.model.Quizz;
import com.mhm.Quiz_Service.model.Response;
import com.mhm.Quiz_Service.repo.QuizzRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {

    @Autowired
    QuizzRepo quizzRepo;
    @Autowired
    QuizzInterface quizzInterface;


    public ResponseEntity<String> createQuizz(String category, int numQ, String title) {

        List<Integer> questions = quizzInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quizz quiz = new Quizz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizzRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        Quizz quizz= quizzRepo.findById(id).get();
        List<Integer> questionsId = quizz.getQuestions();
        List<QuestionWrapper> questions = quizzInterface.getQuestionsById(questionsId).getBody();


        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getResult(int id, List<Response> responses) {

       ResponseEntity<Integer> score = quizzInterface.getScore(responses);
        return score;
    }
}
