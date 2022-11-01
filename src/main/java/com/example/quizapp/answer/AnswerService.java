package com.example.quizapp.answer;

public interface AnswerService {

    Answer fromDTO(AnswerDTO answerDTO);

    AnswerDTO toDTO(Answer answer);

}
