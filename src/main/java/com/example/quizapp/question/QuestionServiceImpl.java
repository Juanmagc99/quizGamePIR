package com.example.quizapp.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        Optional<Question> qst = questionRepository.findById(id);
        if (qst.isPresent()){
            questionRepository.delete(qst.get());
        } else {
            System.out.println("Question to delete not found");
        }
    }

    @Override
    public Question toDTO(QuestionDTO qstDTO) {
        Question question = new Question();
        question.setQst(qstDTO.getQst());
        return question;
    }
}
