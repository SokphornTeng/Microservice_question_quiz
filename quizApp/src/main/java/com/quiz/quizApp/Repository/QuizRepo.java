package com.quiz.quizApp.Repository;

import com.quiz.quizApp.Model.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {
}
