package com.example.quest;

import java.util.Scanner;

public class Game {
    protected Story story;
    protected Character character;

    public Game(Story story, Character character) {
        this.story = story;
        this.character = character;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name!");
        String name = scanner.nextLine();
        Character character = new Character(name);

        Situation start = new Situation("Вступление",
                "Вы начинаете игру. Каков ваш следующий шаг?\n" +
                        "1 - Пойти налево\n" +
                        "2 - Пойти прямо\n" +
                        "3 - Пойти направо\n",
                0, 0, 0, 3);

        start.answers[0] = new Situation("Вы пошли налево",
                "Вы находите сундук, до краёв набитый золотом\n",
                0, 1000, 0, 0);

        Situation straight = new Situation("Вы пошли прямо",
                "Вы встречаете раненого солдата, сидящего у края дороги. Он просит Вас о помощи.\n" +
                        "1 - Помочь\n" +
                        "2 - Убить и ограбить\n" +
                        "3 - Пройти мимо\n",
                0, 0, 0, 3);

        straight.answers[0] = new Situation("Вы помогли солдату",
                "Он говорит, что ему нечем особо отблагодарить Вас, но не забудет этот благородный поступок.\n",
                0, 3, 5, 0);
        straight.answers[1] = new Situation("Вы убили солдата",
                "Хамство и деградация! Упадок морали и нравственности! Но ладно, в его карманах Вы нашли лишь 3 гроша.\n",
                0, 3, 0, 0);
        straight.answers[2] = new Situation("Вы прошли мимо",
                "Равнодушный поступок... Дизреспект\n",
                0, 3, 5, 0);

        start.answers[1] = straight;

        start.answers[2] = new Situation("Вы пошли направо",
                "Пробираясь сквозь кусты, вы неосторожно оступаетесь и, подвернув ногу, " +
                        "проваливаетесь в из ниоткуда появившуююся волчью яму.\n" +
                        "1 - Смириться и подождать\n" +
                        "2 - Попытаться выбраться\n" +
                        "3 - Громко звать на помощь\n",
                0, 0, 0, 3);

        Game game = new Game(new Story(start), character);
        game.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (this.story.currentSituation != null) {
            this.story.currentSituation.show();
            if (this.story.isEnd()) return;
            this.story.go(scanner.nextInt());
        }
    }
}
