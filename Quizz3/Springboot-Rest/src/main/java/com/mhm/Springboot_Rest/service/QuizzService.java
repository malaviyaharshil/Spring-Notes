package com.mhm.Springboot_Rest.service;

import com.mhm.Springboot_Rest.model.Question;
import com.mhm.Springboot_Rest.model.QuestionWrapper;
import com.mhm.Springboot_Rest.model.Quizz;
import com.mhm.Springboot_Rest.model.Response;
import com.mhm.Springboot_Rest.repo.QuestionRepo;
import com.mhm.Springboot_Rest.repo.QuizzRepo;
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
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuizz(String category, int numQ, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category,numQ);
        Quizz q = new Quizz();
        q.setTitle(title);
        q.setQuestions(questions);
        quizzRepo.save(q);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        Optional<Quizz> quizz= quizzRepo.findById(id);
        List<Question> questions = quizz.get().getQuestions();
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        for (Question question : questions) {
            QuestionWrapper questionWrapper = new QuestionWrapper();
            questionWrapper.setQuestionTitle(question.getQuestionTitle());
            questionWrapper.setQuestionId(question.getQuestionId());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());
            questionWrappers.add(questionWrapper);
        }
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getResult(int id, List<Response> responses) {
        Optional<Quizz> quiz = quizzRepo.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        Integer result = 0;
        int i=0;
        for(Question question : questions) {
            if(question.getAnswer().equals(responses.get(i).getAnswer())) {
                result++;
            }
            i++;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
