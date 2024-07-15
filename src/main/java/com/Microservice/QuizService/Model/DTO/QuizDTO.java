package com.Microservice.QuizService.Model.DTO;

public class QuizDTO {

    private String catogoryName;
    private Integer numQuestion;
    private String title;

    public QuizDTO(String catogoryName, Integer numQuestion, String title) {
        this.catogoryName = catogoryName;
        this.numQuestion = numQuestion;
        this.title = title;
    }

    public String getCatogoryName() {
        return catogoryName;
    }

    public void setCatogoryName(String catogoryName) {
        this.catogoryName = catogoryName;
    }

    public Integer getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(Integer numQuestion) {
        this.numQuestion = numQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
