package com.ifmo.jjd.lesson7;

public class Infantry extends BattleUnit{

    public Infantry(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }
    // реализация метода attack(BattleUnit unit) интерфейса AttackAble
    @Override
    public void attack(BattleUnit unit) {
        // 1 если this жив и ловкость unit меньше this:
        // unit.health -= this.attack
        // 2 если unit жив и его ловкость больше this:
        // this.health -= unit.attack
    }
    // реализация метода rest() интерфейса RestAble
    @Override
    public void rest() {
        this.plusHealth(2);
    }
}
