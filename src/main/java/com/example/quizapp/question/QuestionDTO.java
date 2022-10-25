package com.example.quizapp.question;

import com.example.quizapp.answer.AnswerDTO;
import lombok.Data;

import java.util.Map;

@Data
public class QuestionDTO {

    private Long id;

    private String qst;

    private Map<Boolean, AnswerDTO> answers;

}
