package com.ifmo.jjd.lesson13.generic.methods;

public class CustomUtils {
    // типизированные методы generic methods
    // могут быть static и не static

    public static <T> boolean inArray(T[] arr, T elem){
        if (elem == null)
            throw new IllegalArgumentException("elem не должен быть null") ;
        for (T s : arr) {
            if (elem.equals(s)) return true;
        }
        return false;
    }
    // extends - ограничение типов, тип T может быть типом Number или
    // любым другим типом, который его расширает
    // аналогично и для типа K
    public static <T extends Number, K extends Number>
    int compareHashCode(T first, K second) {
        return Integer.compare(first.hashCode(), second.hashCode());
    }

}
