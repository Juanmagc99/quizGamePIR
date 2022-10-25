package com.example.quizapp.question;

import com.example.quizapp.answer.AnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public QuestionDTO getForm(){
        QuestionDTO qstDTO = new QuestionDTO();
        qstDTO.setQst("¿Comó te llamas?");
        qstDTO.setId(0L);

        AnswerDTO aswDTO = new AnswerDTO();
        aswDTO.setId(0L);
        aswDTO.setAnsw("Pablo");
        aswDTO.setResult(Boolean.TRUE);

        AnswerDTO aswDTO2 = new AnswerDTO();
        aswDTO2.setId(1L);
        aswDTO2.setAnsw("Juanma");
        aswDTO2.setResult(Boolean.FALSE);

        Map<Boolean, AnswerDTO> anwers = new HashMap<Boolean, AnswerDTO>();
        anwers.put(Boolean.TRUE, aswDTO);
        anwers.put(Boolean.FALSE, aswDTO2);

        qstDTO.setAnswers(anwers);

        return qstDTO;
    }

    @PostMapping("/question/new")
    public QuestionDTO newQuestion(@RequestBody QuestionDTO newQstDTO){
        return questionService.saveQuestion();
    }
}
