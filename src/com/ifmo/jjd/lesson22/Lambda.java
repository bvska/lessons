package com.ifmo.jjd.lesson22;

public class Lambda {
    public static void main(String[] args) {
        // лямбда - реализация абстрактного метода функционального интерфейса.
        // Функциональный интерфейс - интерфейс, у которого только один абстрактный метод
        // количество дефолтных методов не имеет значение

        // Operation sum = аргументы -> тело метода;
        /*  double execute(double a, double b);
            Синтаксис лямбда:
            Принимаемые аргументы ():
                1. можно не заключать в (), если аргумент 1
                2. в остальных случаях () обязательны (без аргументов или больше 1го)
                3. можно не указывать тип данных аргументов, типы берутся из контекста
                (будут соответствовать типам в методе интерфейса)

            Тело метода (реализация метода):
                1. если реализация метода состоит из 1й инструкции, то тело метода
                не заключается в {}, return по умолчанию
                2. если реализация метода состоит из нескольких инструкций, то тело
                метода необходимо заключить {}. return необходимо указывать явно

            () -> {
                инструкция 1;
                инструкция 2;
                return результат;
            }
        * */
        /*
        Double
        public static double sum(double a, double b) {
            return a + b;
        }
        Calculator
        public double getSum(double a, double b){
            return a + b;
        }
        */
        // double execute(double a, double b);

        Operation sum = (a, b) -> a + b;
        // Double.sum(3, 5); // вызов метода
        sum = Double::sum; // ссылка на метод
        // sum = Calculator::getSum; // ссылка на метод
        System.out.println(Calculator.calculate(56, 78, sum));
        System.out.println(sum.execute(6, 7));

        System.out.println(Calculator.calculate(4, 7, (a, b) -> a - b));

        Operation div = (first, second) -> {
            if (second == 0) throw new  IllegalArgumentException("second не мб равен 0");
            return first / second;
        };


        System.out.println(Calculator.calculate(56, 78, div));
        System.out.println(div.execute(6, 7));
        EditAble tolower = (txt) -> txt.toLowerCase();
        EditAble toupper = (txt) -> txt.toUpperCase();
        EditAble helloWorld = text -> text + " Hello world!";

        System.out.println(tolower.edit("TeXt")); // text
        System.out.println(tolower);

        EditAble doubleText = text -> {
            System.out.println("edit");
            return text + text;
        };
        // сначала вызываем дефолтные методы, потом основной
        System.out.println(doubleText
                .addPrefix("((") // вернет объект типа EditAble
                .addPostFix("))") // вернет объект типа EditAble
                .edit("ДАННЫЕ")); // вернет объект типа String
    }
}

@FunctionalInterface
interface Operation{ // функциональный интерфейс с одним абстрактным методом  execute
    double execute(double a, double b);
}

@FunctionalInterface
interface EditAble{
    String edit(String text); // реализации метода - основной функционал

    // дефолтные методы - вспомогательный функционал,
    // должны возвращать тип данных интерфейса
    default EditAble addPrefix(String prefix) {
        System.out.println("addPrefix");
        return text -> edit(prefix + " " + text);
    }

    default EditAble addPostFix(String postfix){
        System.out.println("addPostFix");
        return text -> edit(text + " " + postfix);
    }
}

class Calculator{
    public double getSum(double a, double b){
        return a + b;
    }
    public static double calculate(double a, double b, Operation operation){
        return operation.execute(a, b);
    }
}


