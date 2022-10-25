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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ans")
    private String ans;

    @Column(name = "result")
    private  Boolean result;

    @ManyToOne()
    @JoinColumn(name = "qst_id", nullable = false)
    private Question question;
}
