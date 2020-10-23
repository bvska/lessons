package com.ifmo.jjd.lesson13.generic.methods;

public class TstGenericMethods {
    public static void main(String[] args) {
        String[] strings = {"qwe", "asd", "zxc"};
        String elem = "qwe";

        System.out.println(CustomUtils.inArray(strings, elem));

        Integer[] integers = {45, 67, 89};
        Integer intVar = 34;

        System.out.println(CustomUtils.inArray(integers, intVar));

        Double doubleVar = 34.8;

        System.out.println(CustomUtils.compareHashCode(intVar, doubleVar));
        CustomUtils.<Integer, Double>compareHashCode(intVar, doubleVar);
        // CustomUtils.<Integer, Integer>compareHashCode(intVar, doubleVar);


    }
}
