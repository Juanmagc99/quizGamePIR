package com.example.quizapp.question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> getAll();

    Optional<Question> findById(Long id);

    Question save(Question question);

    void delete(Long id);

    Question toDTO(QuestionDTO qstDTO);
}
