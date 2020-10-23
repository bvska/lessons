package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;
// если в качестве generic указать <T extends Transport>,
// то carOnService мб типа Transport и любым из его наследников
// соотвественно, carOnService доступны методы Transport

// если в качестве generic указать <T extends Bus>,
// то carOnService мб типа Bus (не Transport) и любым из его наследников
// соотвественно, carOnService доступны методы Bus

// если в качестве generic указать <T extends Transport & Repairing>,
// Transport
// Bus -> Transport -> Repairing
// Train -> Transport
// Tram -> Repairing
public class Garage<T extends Transport & Repairing> {
    private T carOnService;

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }
}
