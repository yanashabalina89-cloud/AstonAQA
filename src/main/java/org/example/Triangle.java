package org.example;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c){
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Невозможно построить треугольник с такими сторонами.");
        }
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    public double getArea(){
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}