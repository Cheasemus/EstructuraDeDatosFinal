package com.ipn.estructuradedatos;

public class Answers
{
    private final String answer;
    private final boolean correct;

    public Answers(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }
}