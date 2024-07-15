package com.Microservice.QuestionService.Repository;


import com.Microservice.QuestionService.Model.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category=:categoryName ORDER BY RANDOM() LIMIT :numQuestion ", nativeQuery = true)
    List<Integer> findByCorrectAnswer(String categoryName, int numQuestion);

}
