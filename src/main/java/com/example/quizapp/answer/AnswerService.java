package com.example.quizapp.answer;

import java.util.Optional;

public interface AnswerService {

    Answer fromDTO(AnswerDTO answerDTO);

    AnswerDTO toDTO(Answer answer);

    Answer editAnswer(AnswerDTO answerDTO);

    Optional<Answer> findById(Long id);

}
