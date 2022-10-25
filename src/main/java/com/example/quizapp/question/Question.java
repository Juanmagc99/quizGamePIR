package com.example.quizapp.question;

import com.example.quizapp.answer.Answer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "qst")
    private String qst;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Answer> answer;
}
