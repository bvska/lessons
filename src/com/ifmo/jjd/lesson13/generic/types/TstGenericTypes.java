package com.ifmo.jjd.lesson13.generic.types;

public class TstGenericTypes {
    public static void main(String[] args) {
        // в <> указываем тип данных, который будет
        // использоваться вместо T для данного объекта
        // если не указать тип данных в <>, то тип данных
        // id Для данного объекта будет Object
        User<String> stringUser = new User<>();
        stringUser.setLogin("qwe");
        stringUser.setPwd("123fef");
        stringUser.setId("12abr343bdyrb454");
        String sId = stringUser.getId();

        // для данного объекта тип T, а соответственно
        // и тип данных id будет Integer
        User<Integer> integerUser = new User<>();
        integerUser.setId(67);
        integerUser.setLogin("asd");
        integerUser.setPwd("2frwt454");
        Integer iId = integerUser.getId();
        // <T, K> T key; K value;
        // для объекта container1
        // тип данных T key - String
        // тип данных K value - Integer
        PairContainer<String, Integer> container1 =
                new PairContainer<>("qwe", 3);
        // тип данных container2
        // T key - String
        // K value - User (тип данных id - Object)
        PairContainer<String, User> container2
                = new PairContainer<>("qwe", stringUser);
        Object oId = container2.getValue().getId();

        // тип данных container3
        // T key - String
        // K value - User (тип данных id - String)
        PairContainer<String, User<String>> container3
                = new PairContainer<>("qwe", stringUser);
        sId = container3.getValue().getId();

        User<Number> numberUser = new User<>();
        numberUser.setLogin("num");
        numberUser.setId(35);

        PairContainer<String, User<Number>> container4 =
                new PairContainer<>("num", numberUser);

    }
}
