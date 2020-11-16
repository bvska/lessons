package com.ifmo.jjd.lesson22;

public class Lambda {
    public static void main(String[] args) {

    }
}


interface Operation{
    double execute(double a, double b);
}

class Calculator{
    public static double calculate(double a, double b, Operation operation){
        return operation.execute(a, b);
    }
}