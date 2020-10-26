package com.ifmo.jjd.lesson13.generic.wildcard;

import com.ifmo.jjd.lesson13.generic.types.PairContainer;
import com.ifmo.jjd.lesson7.BattleUnit;
import com.ifmo.jjd.lesson7.Infantry;
import com.ifmo.jjd.lesson7.King;
import com.ifmo.jjd.lesson7.Unit;

public class TstWildCards<T> {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Animal> animalContainer = new PairContainer<>(1, cat);
        PairContainer<Integer, Cat> catContainer = new PairContainer<>(1, cat);
        PairContainer<Integer, Dog> dogContainer = new PairContainer<>(1, dog);

        TstWildCards.<Animal>copyValue(catContainer, animalContainer);
        // TstWildCards.<Dog>copyValue(catContainer, animalContainer);
        // TstWildCards.<Cat>copyValue(animalContainer, animalContainer);
        TstWildCards.copyValue(animalContainer, animalContainer);
        // TstWildCards.copyValue(dogContainer, catContainer);

        Unit unit = new King(34, 56);
        Infantry infantry = new Infantry(23, 23, 23);
        PairContainer<Integer, Unit> c1 = new PairContainer<>(1, unit);
        PairContainer<Integer, Infantry> c2 = new PairContainer<>(1, infantry);

        copyValueTwo(c2, c1);
    }
    // метод принимает на вход
    // from: объет типа PairContainer,
    // у которог тип T - Integer, a тип К - (? extends M)
    // to: объет типа PairContainer,
    // у которог тип T - Integer, a тип К - (? super M)
    public static <M> void copyValue(
            // extends - передаваемый тип M или его потомки
            // super - передаваемый тип M или его предки
            PairContainer<Integer, ? extends M> from, // для get операций
            PairContainer<Integer, ? super M> to // для put операций
    ) {
        to.setValue(from.getValue());
    }

    public static void copyValueTwo(
            // extends - передаваемый тип M или его потомки
            // super - передаваемый тип M или его предки
            PairContainer<Integer, ? extends BattleUnit> from, // для get операций
            PairContainer<Integer, ? super BattleUnit> to // для put операций
    ) {
//        from.getValue() вернет объект типа BattleUnit, на это указывает
//        ? extends BattleUnit - тип данных мб только BattleUnit или его наследники

//        to.getValue() вернет объект типа BattleUnit, на это указывает
//        ? super BattleUnit - тип данных мб только BattleUnit или его предки
//        to.getValue() // Object
        to.setValue(from.getValue());
    }
}
