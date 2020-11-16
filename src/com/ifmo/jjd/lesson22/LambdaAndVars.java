package com.ifmo.jjd.lesson22;

public class LambdaAndVars {
    private static int staticInt = 12;

    public static void main(String[] args) {
        int localInt = 10;
        Data localObj = new Data("текстовые данные");

        Accumulator plusFive = x ->{ //название localInt->{ не можем использовать в качестве имен аргументов
            // значение локальных переменных (примитивов), объявленных вне лямбда выражения доступны только для чтения:
            // localInt = 100;
            System.out.println("localInt = " + localInt); // но можем прочитать их значения

            // нельзя изменить ссылку на объект, но можно изменить значения свойств объекта по ссылке:
            // localObj = new Data("новый объект");
            System.out.println("localObj = " + localObj);
            localObj.setText("new message");

            // статические переменные полностью доступны для запись и чтения:
            staticInt = 1000;
            System.out.println("staticInt = " + staticInt);
            return 5 + x;
        };
        System.out.println(plusFive.getInt(3));
    }
}

@FunctionalInterface
interface Accumulator{
    int getInt(int someInt);
}

class Data{
    private String text;

    Data(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}
