package com.quiz.quizApp.Service;

import com.quiz.quizApp.Model.Entity.Question;
import com.quiz.quizApp.Model.Request.QuestionRequest;
import com.quiz.quizApp.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




}
