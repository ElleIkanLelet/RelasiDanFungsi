package com.example.relasidanfungsi;

public class Question {

    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    String hint;

    public Question(
            String question,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            String answer,
            String hint
    ) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.hint = hint;
    }
}