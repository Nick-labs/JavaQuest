package com.example.quest;

public class Situation {
    protected String subject, text;
    protected int dK, dA, dR;
    protected Situation[] answers;

    public Situation(String subject, String text, int dK, int dA, int dR, int answersCount) {
        this.subject = subject;
        this.text = text;
        this.dK = dK;
        this.dA = dA;
        this.dR = dR;
        this.answers = new Situation[answersCount];
    }

    public void show() {
        System.out.println(subject);
        System.out.println(text);
    }
}
