package com.example.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private TextView text, subject, textPlayer, textK, textA, textR;
    private LinearLayout buttonsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Character character = new Character(getIntent().getStringExtra("name"), 0, 100, 0);
        game = new Game(fairyTaleStory(), character);

        subject = findViewById(R.id.subject);
        text = findViewById(R.id.text);
        buttonsLayout = findViewById(R.id.buttons);

        textPlayer = findViewById(R.id.textPlayer);
        textK = findViewById(R.id.textK);
        textA = findViewById(R.id.textA);
        textR = findViewById(R.id.textR);

        textPlayer.setText(game.character.name);
    }

    public Story fairyTaleStory() {
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
                "Хамство и деградация! Упадок морали и нравственности! Ладно-ладно, ваше право. В его карманах Вы нашли лишь 3 гроша.\n",
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
                0, 0, 0, 0);
        return new Story(start);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        game.start();
        showSituation(game.story.currentSituation);
    }


    public void showSituation(final Situation situation) {
        buttonsLayout.removeAllViews();
        subject.setText(situation.subject);
        text.setText(situation.text);

        game.character.K += situation.dK;
        game.character.A += situation.dA;
        game.character.R += situation.dR;

        textK.setText(game.character.K + "");
        textA.setText(game.character.A + "");
        textR.setText(game.character.R + "");


        for (int i = 0; i < situation.answers.length; i++) {
            final int j = i;
            Button button = new Button(getBaseContext());
            button.setText(i + 1 + "");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    game.story.currentSituation = situation.answers[j];
                    showSituation(game.story.currentSituation);
                }
            });
            buttonsLayout.addView(button);
        }
        if (situation.answers.length == 0) {
            Button button = new Button(getBaseContext());
            button.setText("Завершить игру");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            buttonsLayout.addView(button);
        }
    }
}
