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
    private QuestionServiceImpl questionService;

    @GetMapping("/questions")
    public QuestionDTO getForm(){
        QuestionDTO qstDTO = new QuestionDTO();
        qstDTO.setQst("¿Comó te llamas?");
        qstDTO.setId(0L);

        AnswerDTO aswDTO = new AnswerDTO();
        aswDTO.setId(0L);
        aswDTO.setOption("Pablo");
        aswDTO.setResult(Boolean.TRUE);
        aswDTO.setCorrect(Boolean.FALSE);

        AnswerDTO aswDTO2 = new AnswerDTO();
        aswDTO2.setId(1L);
        aswDTO2.setOption("Juanma");
        aswDTO2.setCorrect(Boolean.FALSE);
        aswDTO2.setResult(Boolean.FALSE);

        qstDTO.getAnswers().add(aswDTO2);
        qstDTO.getAnswers().add(aswDTO);

        questionService.save(qstDTO);
        System.out.println(qstDTO.getAnswers());
        return qstDTO;
    }


    @PostMapping(value = "/question/new", consumes = "application/json")
    public QuestionDTO newQuestion(@RequestBody QuestionDTO newQstDTO){

        System.out.println(newQstDTO);
        Question question =  this.questionService.save(newQstDTO);
        return questionService.toDTO(question);
    }
}
