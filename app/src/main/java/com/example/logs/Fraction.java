package com.example.logs;

public class Fraction {
    public Fraction (int n, int d) throws Exception {
        if (d == 0) {
            throw new Exception("Нельзя создать дробь с нулевым знаменателем");
        }
    }
}
