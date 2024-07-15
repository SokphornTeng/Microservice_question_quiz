package com.quiz.quizApp.Model.Response;

import com.quiz.quizApp.Model.Entity.Question;

import java.io.Serializable;

public class QuestionResponse implements Serializable {

    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String difficultylevel;
    private String category;

    public QuestionResponse(Long id, String questionTitle, String option1, String option2, String option3, String option4, String correctAnswer, String difficultylevel, String category) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.difficultylevel = difficultylevel;
        this.category = category;
    }

    public static QuestionResponse QuestionResp(Question newQuest){
        return  new QuestionResponse(
                newQuest.getId(),
                newQuest.getQuestionTitle(),
                newQuest.getOption1(),
                newQuest.getOption2(),
                newQuest.getOption3(),
                newQuest.getOption4(),
                newQuest.getCorrectAnswer(),
                newQuest.getDifficultylevel(),
                newQuest.getCategory()

        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
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
