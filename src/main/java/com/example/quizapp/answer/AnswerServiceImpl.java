package com.example.quizapp.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer fromDTO(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setId(answerDTO.getId());
        answer.setOption(answerDTO.getOption());
        answer.setCorrect(answerDTO.getCorrect()    );
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

    @Override
    public Answer editAnswer(AnswerDTO answerDTO) {
        Optional<Answer> answerOp = this.findById(answerDTO.getId());
        if (answerOp.isPresent()){
            Answer answer = answerOp.get();
            answer.setOption(answerDTO.getOption());
            answer.setCorrect(answerDTO.getCorrect());
            return answer;
        }
        return null;
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return this.answerRepository.findById(id);
    }
}
