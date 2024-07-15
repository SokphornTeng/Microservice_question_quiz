package com.Microservice.QuestionService.Controller;


import com.Microservice.QuestionService.Model.DTO.QuestionWrapper;
import com.Microservice.QuestionService.Model.Entity.Question;
import com.Microservice.QuestionService.Model.Request.QuestionRequest;
import com.Microservice.QuestionService.Model.Response.QuestionResponse;
import com.Microservice.QuestionService.Model.Response.Responses;
import com.Microservice.QuestionService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    private final QuestionService Qservice;
    @Autowired
    public QuestionController(QuestionService qservice) {
        Qservice = qservice;
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> createQuest(@RequestBody QuestionRequest Qreq){
        Question newQ = this.Qservice.createQuestion(Qreq);
        return ResponseEntity.ok(QuestionResponse.QuestionResp(newQ));
    }
    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getListing(){
        List<QuestionResponse> newList =  this.Qservice.listingQuest().stream().map(QuestionResponse::QuestionResp).toList();
        return ResponseEntity.ok(newList);
    }
    @GetMapping("/list")
    public List<Question> getAllListing(){
        return this.Qservice.listingQuest();
    }

    @GetMapping("/{cat}")
    public List<Question> getQuestionByCategory(@PathVariable("cat") String category){
        return this.Qservice.questionCategory(category);
    }

//    @PostMapping
//    public String addData(@RequestBody Question myQ){
//        return this.Qservice.addQuiz(myQ);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponse> updateData(@PathVariable("id") Long id, @RequestBody QuestionRequest req) throws Exception {
          Question newQ = this.Qservice.updateQuestion(id, req);
          return  ResponseEntity.ok(QuestionResponse.QuestionResp(newQ));
    }


    // generat
    // getQuestion (questionId)
    // getScore

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestion){
        return this.Qservice.getQuestionForQuiz(categoryName, numQuestion);
    }

    @PostMapping("/getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(@RequestBody List<Integer> questionID){
      return this.Qservice.getQuestionsFromID(questionID);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Responses> responses){
       return this.Qservice.getScore(responses);
    }

}
