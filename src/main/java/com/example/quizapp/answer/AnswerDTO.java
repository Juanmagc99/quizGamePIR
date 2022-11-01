package com.example.quizapp.answer;

import com.example.quizapp.question.QuestionDTO;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
public class AnswerDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("option")
    private String option;

    @JsonProperty
    private Boolean correct;

    @JsonProperty("result")
    private Boolean result;

}
