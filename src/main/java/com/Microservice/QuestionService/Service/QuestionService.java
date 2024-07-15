package com.Microservice.QuestionService.Service;

import com.Microservice.QuestionService.Model.DTO.QuestionWrapper;
import com.Microservice.QuestionService.Model.Entity.Question;
import com.Microservice.QuestionService.Model.Request.QuestionRequest;
import com.Microservice.QuestionService.Model.Response.Responses;
import com.Microservice.QuestionService.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepo repoQuestion;
    @Autowired
    public QuestionService(QuestionRepo repoQuestion) {
        this.repoQuestion = repoQuestion;
    }

    public Question createQuestion(QuestionRequest QReq){
        Question newQ = QReq.QuestReq();
        return  this.repoQuestion.save(newQ);
    }

    public List<Question> listingQuest(){
        return this.repoQuestion.findAll();
    }

    public List<Question> questionCategory(String category) {
        return  this.repoQuestion.findByCategory(category);
    }

//    public String addQuiz(Question q){
//       this.repoQuestion.save(q);
//        return "Success!!!";
//    }

    public Question updateQuestion(Long id, QuestionRequest req) throws Exception {
         Question updateNew = this.repoQuestion.findById(id).orElseThrow(() -> new Exception());
         updateNew.setQuestionTitle(req.getQuestionTitle());
         updateNew.setOption1(req.getOption1());
         updateNew.setOption2(req.getOption2());
         updateNew.setOption3(req.getOption3());
         updateNew.setOption4(req.getOption4());
         updateNew.setDifficultylevel(req.getDifficultylevel());
         updateNew.setCategory(req.getCategory());
          return  this.repoQuestion.save(updateNew);
    }


    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestion) {
        List<Integer> questions = this.repoQuestion.findByCorrectAnswer(categoryName, numQuestion);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(List<Integer> questionID) {

        List<QuestionWrapper> Qwrappers = new ArrayList<>();
        List<Question> quest = new ArrayList<>();

        for(Integer id : questionID){
            quest.add(this.repoQuestion.findById(Long.valueOf(id)).get());
        }
        for(Question questNew : quest){
//            QuestionWrapper wrapper = new QuestionWrapper(
//                    questNew.getId(),
//                    questNew.getQuestionTitle(),
//                    questNew.getOption1(),
//                    questNew. getOption2(),
//                    questNew.getOption3(),
//                    questNew.getOption4()
//            );
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(questNew.getId());
            wrapper.setQuestionTitle(questNew.getQuestionTitle());
            wrapper.setOption1(questNew.getOption1());
            wrapper.setOption2(questNew.getOption2());
            wrapper.setOption3(questNew.getOption3());
            wrapper.setOption4(questNew.getOption4());
            Qwrappers.add(wrapper);

        }
        return new ResponseEntity<>(Qwrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Responses> responses) {

        int right = 10;
        for(Responses resp : responses){
            Question quest = this.repoQuestion.findById(resp.getId()).get();
            if(resp.getResponse().equals(quest.getCorrectAnswer())){
                right++;
            }
        }
       return new ResponseEntity<>(right, HttpStatus.OK);

    }


}
