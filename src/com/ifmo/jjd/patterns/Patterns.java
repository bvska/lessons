package com.ifmo.jjd.patterns;

import com.ifmo.jjd.patterns.builder.NutritionFacts;
import com.ifmo.jjd.patterns.decorator.DateDecorator;
import com.ifmo.jjd.patterns.decorator.ILogger;
import com.ifmo.jjd.patterns.decorator.LevelDecorator;
import com.ifmo.jjd.patterns.decorator.Logger;

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
    }
}
