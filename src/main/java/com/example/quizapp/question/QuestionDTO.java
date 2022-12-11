package com.example.quizapp.question;

import com.example.quizapp.answer.AnswerDTO;
import com.example.quizapp.answer.CustomListAnswerDeserialize;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("qst")
    private String qst;

    @JsonProperty("answers")
    private List<AnswerDTO> answers = new ArrayList<AnswerDTO>();

}
