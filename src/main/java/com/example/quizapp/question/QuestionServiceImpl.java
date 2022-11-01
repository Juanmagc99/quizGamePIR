package com.example.quizapp.question;

import com.example.quizapp.answer.Answer;
import com.example.quizapp.answer.AnswerDTO;
import com.example.quizapp.answer.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerServiceImpl answerService;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(QuestionDTO questionDTO) {
        return questionRepository.save(this.fromDTO(questionDTO));
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
    public Question fromDTO(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setQst(questionDTO.getQst());
        ArrayList<Answer> answers = new ArrayList<Answer>();
        List<AnswerDTO> answersDTO = questionDTO.getAnswers();

        for (AnswerDTO answerDTO: answersDTO){
            Answer answer = answerService.fromDTO(answerDTO);
            answer.setQuestion(question);
            answers.add(answer);
        }

        question.setAnswer(answers);
        return question;
    }

    @Override
    public QuestionDTO toDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setQst(question.getQst());
        questionDTO.setAnswers(question.getAnswer().stream().map(a -> this.answerService.toDTO(a)).collect(Collectors.toList()));
        return questionDTO;
    }


}
