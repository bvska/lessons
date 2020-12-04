package com.ifmo.jjd.patterns;

import com.ifmo.jjd.patterns.builder.NutritionFacts;
import com.ifmo.jjd.patterns.decorator.DateDecorator;
import com.ifmo.jjd.patterns.decorator.ILogger;
import com.ifmo.jjd.patterns.decorator.LevelDecorator;
import com.ifmo.jjd.patterns.decorator.Logger;
import com.ifmo.jjd.patterns.observer.Observer;
import com.ifmo.jjd.patterns.observer.StateClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {

        // Строитель
        NutritionFacts apple = new NutritionFacts.Builder(3)
                .calories(100)
                .fat(10)
                .build();
        System.out.println(apple);

        // Декоратор
        Logger baseLogger = new Logger();
        baseLogger.write("Сообщение №1");

        ILogger addDate = new DateDecorator(baseLogger);
        addDate.write("Сообщение №2");

        ILogger logger = new LevelDecorator(new DateDecorator(new Logger()));
        logger.write("Сообщение №3");
        // LevelDecorator: "Сообщение №3" + число
        // DateDecorator: "Сообщение №3 число" + дата
        // Logger: выводит в консоль "Сообщение №3 число дата"


        // Наблюдатель / Анонимные классы
        Observer firstObserver = new Observer() {

            @Override
            public void greenEvent(int code) {
                System.out.println("Реакция firstObserver " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("Реакция firstObserver " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("Реакция firstObserver " + code);
            }
        };
        Observer secondObserver = new Observer() {
            @Override
            public void greenEvent(int code) {
                System.out.println("Реакция secondObserver " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("Реакция secondObserver " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("Реакция secondObserver " + code);
            }
        };

        System.out.println(firstObserver.getClass());
        System.out.println(secondObserver.getClass());

        System.out.println(Arrays.toString(firstObserver.getClass().getDeclaredConstructors()));

        StateClass stateClass = new StateClass();
        stateClass.addObserver(firstObserver);
        stateClass.addObserver(secondObserver);

        // получение числа из консоли, если ввели 0, выходим из цикла
//        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            int i = 0;
//            try {
//                i = Integer.parseInt(name.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (i == 0) break;
//            stateClass.changeState(i);
//        }

        Scanner scanner = new Scanner(System.in);
        int a;
        while (true) {
            System.out.println(" input a number");
            a = scanner.nextInt();
            if (a == 0) break;
            stateClass.changeState(a);
        }

    }
}

