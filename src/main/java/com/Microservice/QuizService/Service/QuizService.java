package com.Microservice.QuizService.Service;

import com.Microservice.QuizService.Feign.QuizInterface;
import com.Microservice.QuizService.Model.DTO.QuestionWrapper;
import com.Microservice.QuizService.Model.Entity.Quiz;
import com.Microservice.QuizService.Model.Response.Responses;
import com.Microservice.QuizService.Repository.QuizRepo;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private final QuizRepo quizRepo;
    @Autowired
    private final QuizInterface quizInterface;

    public QuizService(QuizRepo quizRepo, QuizInterface quizInterface) {
        this.quizRepo = quizRepo;
        this.quizInterface = quizInterface;
    }

    public ResponseEntity<String> addingQuiz(String category, int numQ, String title){

        List<Integer> question = this.quizInterface.getQuestionForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsID(question);
        this.quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Long id) {

             Quiz quiz = this.quizRepo.findById(id).get();
             List<Integer> questionID = quiz.getQuestionsID();
             ResponseEntity<List<QuestionWrapper>> myQuestion =  this.quizInterface.getQuestionsFromID(questionID);
             return myQuestion;
    }


    public ResponseEntity<Integer> calculateResult(Long id, List<Responses> response) {
        ResponseEntity<Integer> score = this.quizInterface.getScore(response);
        return score;
    }
}


