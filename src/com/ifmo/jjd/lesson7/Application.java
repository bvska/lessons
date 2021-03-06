package com.ifmo.jjd.lesson7;

public class Application {
    public static void main(String[] args) {
        King king1 = new King(100, 10);
        King king2 = new King(100, 15);

        king1.generateArmy();
        king2.generateArmy();

        king1.startAttack(king2);
        king2.startAttack(king1);


        System.out.println(king1.getAttackResult());
        System.out.println(king2.getAttackResult());

        king1.addUnits();
        System.out.println(king1.getAttackResult());
    }
}


/* Все юниты обладают следующими характеристиками: очки здоровья, очки ловкости
 * Все юниты имеют возможность восполнять очки здоровья во время отдыха (каждый тип юнита делает это по своему)
 * */

/* Все боевые юниты обладают следующими характеристиками:
 * очки здоровья, очки ловкости, очки атаки
 * Каждый боевой юнит имеет возможность атаковать другого боевого юнита (каждый тип юнита делает это по своему)
 * */

/* Пехотинец считается боевым юнитом и не обладает дополнительными характеристиками
 * Данные для рандома:
 * очки здоровья [20;60]
 * очки ловкости [5;15]
 * очки атаки [5;15]
 * */

/* Рыцарь считается боевым юнитом и обладает 2 очками дополнительной атаки
 * Данные для рандома:
 * очки здоровья [10;50]
 * очки ловкости [5;15]
 * очки атаки [8;18]
 */

/*Король (юнит) обладает дополнительными характеристиками: количество золота (изначально у каждого 600)
 * Король имеет возможность собирать армию боевых юнитов (не более 20), на что тратит 250 золотых,
 * Король имеет возможность восполнять ряды армии после боя, на что тратит 20 золотых за юнита
 * Король имеет возможность напасть своей армией  на армию другого короля: рандомный юнит из одной армии
 * нападает на рандомного юнита из другой (если ловкость позволяет юнит уворачивается от нападающего)
 * Король должен иметь возможность сообщить о количестве живых юнитов в его армии
 * Данные для рандома:
 * очки здоровья [100;150]
 * очки ловкости [3;7]
 */
