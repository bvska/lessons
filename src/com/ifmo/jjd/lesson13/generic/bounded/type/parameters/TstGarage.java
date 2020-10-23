package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);

        // тип поля carOnService объекта garage1 - Bus!
        Garage<Bus> garage1 = new Garage<>();
        garage1.setCarOnService(bus);
        System.out.println(garage1.getCarOnService().isWiFi());

        // тип поля carOnService объекта garage2 - Transport!
        Garage<Transport> garage2 = new Garage<>();
        garage2.setCarOnService(bus);
        garage2.setCarOnService(train);


    }
}