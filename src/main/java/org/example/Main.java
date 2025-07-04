package org.example;

public class Main {

    public static double celsiusToFahrenheit(double value) {
        return value * 9/5 + 32;
    }

    public static double fahrenheitToCelsius(double value) {
        return (value - 32) * 5/9;
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println(celsiusToFahrenheit(0));
        System.out.println(fahrenheitToCelsius(32));

    }
}
