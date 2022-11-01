package com.example.quizapp.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer fromDTO(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setOption(answerDTO.getOption());
        answer.setCorrect(answerDTO.getResult());
        answer.setQuestion(null);
        return answer;
    }

    @Override
    public AnswerDTO toDTO(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setOption(answer.getOption());
        answerDTO.setCorrect(answer.getCorrect());
        answerDTO.setResult(null);
        return answerDTO;
    }
}
