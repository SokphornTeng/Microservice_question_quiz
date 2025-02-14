package com.quiz.quizApp.Model.Request;

import com.quiz.quizApp.Model.Entity.Question;
import lombok.Data;

import java.io.Serializable;

public class QuestionRequest implements Serializable {

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String difficultylevel;
    private String category;

    public QuestionRequest(String questionTitle, String option1, String option2, String option3, String option4, String correctAnswer, String difficultylevel, String category) {
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.difficultylevel = difficultylevel;
        this.category = category;
    }

    public Question QuestReq(){
        Question newQuestion = new Question();
        newQuestion.setQuestionTitle(this.questionTitle);
        newQuestion.setOption1(this.option1);
        newQuestion.setOption2(this.option2);
        newQuestion.setOption3(this.option3);
        newQuestion.setOption4(this.option4);
        newQuestion.setCorrectAnswer(this.correctAnswer);
        newQuestion.setDifficultylevel(this.difficultylevel);
        newQuestion.setCategory(this.category);
        return newQuestion;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
