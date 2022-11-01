package com.example.quizapp.answer;

import com.example.quizapp.question.Question;
import lombok.Data;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "options")
    private String option;

    @Column(name = "result")
    private  Boolean correct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qst_id", nullable = false)
    private Question question;
}
