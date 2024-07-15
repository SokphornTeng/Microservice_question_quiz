package com.quiz.quizApp.Controller;

import com.quiz.quizApp.Model.DTO.QuestionWrapper;
import com.quiz.quizApp.Model.Entity.Question;
import com.quiz.quizApp.Model.Entity.Quiz;
import com.quiz.quizApp.Model.Response.Responses;
import com.quiz.quizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    private QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
            return quizService.addingQuiz(category, numQ, title);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Long id){
          return this.quizService.getQuizQuestion(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<Responses>  response){
         return this.quizService.calculateResult(id, response);
    }

}
