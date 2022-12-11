package com.example.quizapp.question;

import com.example.quizapp.answer.AnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping("/questions")
    public List<QuestionDTO> getAllQuestions(){
        List<QuestionDTO> questionsDTO = questionService.getAll().stream()
                .map(q -> questionService.toDTO(q)).collect(Collectors.toList());
        return questionsDTO;
    }

    //@GetMapping("/question/{question_id}")


    @PutMapping("/question/edit/{question_id}")
    public QuestionDTO editQuestion(@RequestBody QuestionDTO editQstDTO, @PathVariable Long question_id){
        return questionService.toDTO(questionService.editQuestion(question_id, editQstDTO));
    }


    @PostMapping(value = "/question/new", consumes = "application/json")
    public QuestionDTO newQuestion(@RequestBody QuestionDTO newQstDTO){
        Question question =  this.questionService.save(newQstDTO);
        return questionService.toDTO(question);
    }
}
