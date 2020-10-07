package com.ifmo.jjd.lesson7;

// extends - наследование (множественное наследование запрещено)
// Класс BattleUnit наследуется от класса Unit
// Класс BattleUnit - доерний класс
// Класс Unit - родительский класс
// Дочерний класс получает доступ ко всем доступным свойствам
// и методам родительского класса

abstract public class BattleUnit
        extends Unit
        implements AttackAble{
    protected int attackPoints;

    public BattleUnit(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints); // вызов конструктора родителя
        if (attackPoints <= 0)
            throw new IllegalArgumentException("attackPoints <= 0");
        this.attackPoints = attackPoints;
    }

    // класс BattleUnit реализует (имплементирует) интерфейс
    // RestAble и AttackAble, в которых есть методы run с реализацией
    // В такой ситуации мы обязаны явно указать, какой метод выбрать
    @Override
    public void run() {
        System.out.println("Реализация run BattleUnit");
    }
}
