package com.example.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = 1, A = 100, P = 50;
        System.out.println("Вы прошли собеседование и вот-вот станете сотрудниуом Корпорации. \n Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        String name;
        name = in.next();
        System.out.println("=====\nКарьера:" + K + "\tАктивы:" + A + "т.р.\tРепутация:" + P + "%\n=====");
        System.out.println("Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему партию \n ПО МС Виндовс. Ему в принципе достаточно взять 100 коробок версии HOME.");
        System.out.println("- (1)у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок \n ULTIMATE по 50тр");
        System.out.println("- (2)чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок \n PRO по 10тр");
        System.out.println("- (3)как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр");
        int a1 = in.nextInt();
        if (a1 == 1) {
            K += 0;
            A += -10;
            P += -10;
            System.out.println("=====\nКарьера:" + K + "\tАктивы:" + A + "т.р.\tРепутация:" + P + "%\n=====");
            // Следующие ситуации для этой ветки сюжета
        } else if (a1 == 2) {
            K += 1;
            A += 100;
            P += 0;
            System.out.println("=====\nКарьера:" + K + "\tАктивы:" + A + "т.р.\tРепутация:" + P + "%\n=====");
            // Следующие ситуации для этой ветки сюжета
        } else {
            K += 0;
            A += 50;
            P += 1;
            System.out.println("=====\nКарьера:" + K + "\tАктивы:" + A + "т.р.\tРепутация:" + P + "%\n=====");
            // Следующие ситуации для этой ветки сюжета
        }
        System.out.println("Конец");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
