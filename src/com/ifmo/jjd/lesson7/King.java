package com.ifmo.jjd.lesson7;

public class King extends Unit {
    private int gold = 600;
    private BattleUnit[] army = new BattleUnit[20];

    public King(int healthPoints, int agilityPoints) {
        super(healthPoints, agilityPoints);
    }

    public void plusGold(int gold) {
        if (gold <= 0) return;
        this.gold += gold;
    }

    public void minusGold(int gold) {
//        if (gold <= 0) return;
//        if (hasGold()) {
//            this.gold -= gold;
//            if (!hasGold()) this.gold = 0;
//        }

        if (gold > 0 || this.gold >= gold) this.gold -= gold;

    }

    public boolean hasGold() {
        return gold > 0;
    }

    public void generateArmy() {
        // первые 3 - пехотинцы, остальные - рыцари
        // объекты типа Infantry и Knight можно добавить в массив BattleUnit[],
        // тк BattleUnit - их общий тип данных (благодаря наследованию)
        // при этом объектам внутри массива не будут доступны их собственные методы
        // Все переопределенные методы будут доступны
        /** очки здоровья [20;60] пехотинец
         * очки ловкости [5;15]
         * очки атаки [5;15]*/
        /** очки здоровья [10;50] рыцарь
         * очки ловкости [5;15]
         * очки атаки [8;18]*/
        if (this.gold < 250) return;
        for (int i = 0; i < 3; i++) {
            army[i] = new Infantry(
                    (int) (Math.random() * 41) + 20,
                    (int) (Math.random() * 11) + 5,
                    (int) (Math.random() * 11) + 5
            );
        }
        for (int i = 3; i < army.length; i++) {
            army[i] = new Knight(
                    (int) (Math.random() * 41) + 10,
                    (int) (Math.random() * 11) + 5,
                    (int) (Math.random() * 11) + 8
            );
        }
        minusGold(250);
    }

    public void addUnits() {
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= 20 && !army[i].isAlive()) {
                army[i] = new Knight(
                        (int) (Math.random() * 41) + 10,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 8
                );
                minusGold(20);
            }
        }
    }
}
