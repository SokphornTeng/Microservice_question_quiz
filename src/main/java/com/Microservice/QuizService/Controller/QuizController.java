package com.Microservice.QuizService.Controller;

import com.Microservice.QuizService.Model.DTO.QuestionWrapper;
import com.Microservice.QuizService.Model.DTO.QuizDTO;
import com.Microservice.QuizService.Model.Response.Responses;
import com.Microservice.QuizService.Service.QuizService;
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

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO) {
            return quizService.addingQuiz(quizDTO.getCatogoryName(), quizDTO.getNumQuestion(), quizDTO.getTitle());
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
