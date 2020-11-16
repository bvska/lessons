package com.ifmo.jjd.lesson22;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        /*
           В java есть определенный набор готовых функциональных интерфейсов
           * Predicate<T>: boolean test(T t); для проверки на соответствие условию
           * Function<T, R>: R apply(T t); T и R могут быть одинаковыми типами данных
           * UnaryOperator<T>: T apply(T t);
           BiFunction<T, U, R>: R apply(T t, U u);
           * BinaryOperator<T>: T apply(T t1, T t1);
           * Consumer<T>: void accept(T t);
        */
// import java.util.function.Predicate;
        // Predicate
        // реализация метода test:
        // 1. принимает на вход Integer и возвращает true, если число четное
        // 2. принимает на вход Integer и возвращает true, если число положительное

        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        Predicate<Integer> pos = integer -> integer > 0;

        System.out.println(isEven.test(78));
        // положительное и четное
        System.out.println(pos.and(isEven).test(56)); // &&
        // положительное и четное
        System.out.println(pos.or(isEven).test(56)); // ||

        System.out.println(((Predicate<Integer>) (a -> (a > 0))).test(5));

        // Function<T, R>: R apply(T t);
        // возведение целого числа в квадрат
        // умножение целого числа на 2
        Function<Integer, Integer> s = x -> x * x;
        Function<Integer, Integer> add = x -> x * 2;
        // compose(before) - действие, переданное в метод, выполнятся до основного
        // andThen(after) - действие, переданное в метод, выполнятся после основного
        int result = add // 3
                .compose(s) // 1
                .andThen(s) // 4
                .compose(s) // 2
                .apply(3);
        System.out.println(result);
    }
}
