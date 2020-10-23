package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class CustomGarage extends Garage{
    // getCarOnService вернет тип Transport,
    // тк он указан в классе Garage<T extends Transport & Repairing>
    public void checkItem(){
        System.out.println(this.getCarOnService().getNum());
    }
}

class CustomGarage2 extends Garage<Transport> {
    // getCarOnService вернет тип Transport,
    // тк он указан в CustomGarage2 extends Garage<Transport>
    public void checkItem(){
        System.out.println(this.getCarOnService().getNum());
    }
}

class CustomGarage3 extends Garage<Bus> {
    // getCarOnService вернет тип Bus,
    // тк он указан в CustomGarage3 extends Garage<Bus>
    public void checkItem(){
        System.out.println(this.getCarOnService().isWiFi());
    }
}
