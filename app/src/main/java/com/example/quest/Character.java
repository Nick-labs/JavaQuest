package com.example.quest;

public class Character {
    protected int K, A, R = 0;

    protected String name;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int K, int A, int R) {
        this.name = name;
        this.K = K;
        this.A = A;
        this.R = R;
    }
}
