package com.Microservice.QuizService.Feign;

import com.Microservice.QuizService.Model.DTO.QuestionWrapper;
import com.Microservice.QuizService.Model.Response.Responses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {

    @GetMapping("api/questions/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestion);

    @PostMapping("api/questions/getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(@RequestBody List<Integer> questionID);

    @PostMapping("api/questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Responses> responses);

}
