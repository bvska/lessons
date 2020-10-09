package com.ifmo.jjd.lesson8;
// ключевое слово final можно использовать с
// класами - от final класса нельзя наследоваться
// свойсвами / поля / атрибуты - не могут быть изменены,
// значения должны задаваться при объявлении или в конструкторе
// методами - final методы нельзя переопределять в дочерних классах
// аргументами методов - final аргументы доступны только для чтения
// переменными

// ключевое слово static можно использовать с
// классами
// со свойствами
// с методами
// в таком случае свойства и методы не пренадлежат объектам,
// а пренадлежат самому классу

// final и static можно использовать вместе

import java.util.Arrays;

public class SomeUtils {
    private final String PREFIX;
    private final double PI_VAR = 3.14;

    static final double E_VAR;
    static double someVar;

    static {
        someVar = 90;
        E_VAR = 2.718;
    }

    public SomeUtils(String prefix) {
        this.PREFIX = prefix;
    }

    public final void someVoid(final int num, final int[] nums) {
        System.out.println("num = " + num);
        // num = 90;
        System.out.println(Arrays.toString(nums));
        // nums = new int[]{};
        nums[0] = 122;
    }

    // статический метод
    public static int sum(int a, int b) {
        // из статических методов нельзя обращаться к нестатическим
        // свойствам и методам
        return a + b;
    }

    public static int random(int min, int max) {
        return 0;
    }

    public static void main(String[] args) {
        // вызов статического метода: ИмяКласса.имяМетода();
        System.out.println(SomeUtils.sum(45, 89));
        // Arrays.toString();
        // Math.random();
    }
}

/*final class MyUtils extends SomeUtils {
    public final void someVoid(){ }
}*/

// class CustomUtils extends MyUtils{}


