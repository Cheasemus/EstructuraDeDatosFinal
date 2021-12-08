package com.ipn.estructuradedatos;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questions
{
    private final int id;
    private final String question;
    private List<Answers> answers = new ArrayList<>();
    private final int image;
    private String correctAnswer = "";

    public Questions(int id, String question, List<Answers> answers, int image) {
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.image = image;
    }

    public List<Answers> shuffleAnswers()
    {
        Collections.shuffle(answers);
        return answers;
    }

    public String getCorrect()
    {
        for (Answers correct:answers) {
            correctAnswer = correct.getAnswer();
            if(correct.isCorrect())
                break;
        }
        return correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getImage() {
        return image;
    }
}
