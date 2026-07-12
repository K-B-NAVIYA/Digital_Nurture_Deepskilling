package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text")
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "op_qu_id")
    private Question question;

    public Option() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}