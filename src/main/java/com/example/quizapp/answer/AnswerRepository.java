package com.example.quizapp.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Override
    Optional<Answer> findById(Long aLong);

    @Override
    List<Answer> findAll();

    @Override
    void delete(Answer answer);
}
