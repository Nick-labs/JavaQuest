package com.example.quest;

import java.util.Scanner;

public class Story {
    protected Situation currentSituation;

    public Story(Situation currentSituation) {
        this.currentSituation = currentSituation;
    }

    public void go(int asnwerNumber) {
        if (isEnd()) {
            currentSituation = null;
        } else currentSituation = currentSituation.answers[asnwerNumber - 1];
    }

    public boolean isEnd() {
        boolean is = currentSituation.answers.length == 0;
        if (is) System.out.println("Вы успешно завершили игру");
        return is;
    }
}
