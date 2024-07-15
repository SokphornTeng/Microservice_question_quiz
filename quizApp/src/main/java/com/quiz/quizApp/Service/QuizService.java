package com.quiz.quizApp.Service;

import com.quiz.quizApp.Model.DTO.QuestionWrapper;
import com.quiz.quizApp.Model.Entity.Question;
import com.quiz.quizApp.Model.Entity.Quiz;
import com.quiz.quizApp.Model.Response.Responses;
import com.quiz.quizApp.Repository.QuestionRepo;
import com.quiz.quizApp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepo quizRepo;
    private final QuestionRepo questionRepo;
    @Autowired
   public QuizService(QuizRepo quizRepo, QuestionRepo questionRepo) {
        this.quizRepo = quizRepo;
        this.questionRepo = questionRepo;
    }

    public ResponseEntity<String> addingQuiz(String category, int numQ, String title){

        List<Question> listQ = this.questionRepo.findByCorrectAnswer(category, numQ);

        Quiz newQuiz = new Quiz();
        newQuiz.setTitle(title);
        newQuiz.setQuestions(listQ);
        this.quizRepo.save(newQuiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Long id) {

        Optional<Quiz> quiz = this.quizRepo.findById(id);

        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4());
            questionForUser.add(qw);
        }
        return new  ResponseEntity<>(questionForUser, HttpStatus.OK);

    }


    public ResponseEntity<Integer> calculateResult(Long id, List<Responses> response) {

        Quiz quiz = this.quizRepo.findById(id).get();
        List<Question> quest = quiz.getQuestions();
        int rigth = 0;
        int i = 0;
        for(Responses resp :response){
           if(resp.getResponse().equals(quest.get(i).getCorrectAnswer())) {
               rigth++;
           }
          i++;
        }
     return new ResponseEntity<>(rigth, HttpStatus.OK);
    }
}


