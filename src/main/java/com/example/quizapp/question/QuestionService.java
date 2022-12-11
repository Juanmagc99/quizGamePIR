package com.example.quizapp.question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> getAll();

    Optional<Question> findById(Long id);

    Question save(QuestionDTO questionDTO);

    void delete(Long id);

    Question fromDTO(QuestionDTO questionDTO);

    QuestionDTO toDTO(Question question);

    Question editQuestion(Long qstId,QuestionDTO questionDTO);

}
