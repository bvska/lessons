package com.ifmo.jjd.lesson8;

public class ConverterApp {
    public static void main(String[] args) {
        IConverter converter = new FConverter();
        // какие методы будут доступны


        FConverter fConverter = new FConverter();
        // какие методы будут доступны
        KConverter kConverter = new KConverter();
        // какие методы будут доступны

        IConverter[] converters = {converter, fConverter, kConverter};
        for (IConverter iConverter : converters) {
            // какие методы будут доступны

        }
    }
}

interface IConverter {
    void convert();
    double getConvertedValue();

}
class FConverter implements IConverter{

    @Override
    public void convert() {
        System.out.println("FConverter: convert");
    }

    @Override
    public double getConvertedValue() {
        System.out.println("FConverter: get");
        return 0;
    }

    public void printData(){
        System.out.println("FConverter: printData");
    }
}

class KConverter implements IConverter{

    @Override
    public void convert() {
        System.out.println("KConverter: convert");
    }

    @Override
    public double getConvertedValue() {
        System.out.println("KConverter: get");
        return 0;
    }

    private void printData(){
        System.out.println("KConverter: printData");
    }
}
