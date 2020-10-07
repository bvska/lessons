package com.ifmo.jjd.lesson7;

// extends - наследование (множественное наследование запрещено)
// Класс BattleUnit наследуется от класса Unit
// Класс BattleUnit - доерний класс
// Класс Unit - родительский класс
// Дочерний класс получает доступ ко всем доступным свойствам
// и методам родительского класса

public class BattleUnit extends Unit{
    protected int attackPoints;

    public BattleUnit(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints); // вызов конструктора родителя
        if (attackPoints <= 0)
            throw new IllegalArgumentException("attackPoints <= 0");
        this.attackPoints = attackPoints;
    }

}
