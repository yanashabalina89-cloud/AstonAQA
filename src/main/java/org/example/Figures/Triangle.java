package org.example.Figures;

import java.awt.*;

public class Triangle extends Figure{
    private static final int COUNT_SIDES = 3;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c, Color backgroundColor, Color borderColor){
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Невозможно построить треугольник с такими сторонами.");
        }
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public Triangle(double[] sides, Color backgroundColor, Color borderColor){
        this(sides[0], sides[1], sides[2], backgroundColor, borderColor);
        if (sides.length != COUNT_SIDES) {
            throw new IllegalArgumentException("В треугольнике должно быть 3 стороны.");
        }
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double[] getSizes() {
        return new double[]{this.sideA, this.sideB, this.sideC};
    }

    public double getArea(){
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
