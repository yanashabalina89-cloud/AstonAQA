package org.example.Figures;

import java.awt.*;

public class Rectangle extends Figure {
    private static final int COUNT_SIDES = 2;
    private double width;
    private double height;

    public Rectangle(double width, double height, Color backgroundColor, Color borderColor) {
        if (!isValidRectangle(width, height)) {
            throw new IllegalArgumentException("Невозможно построить прямоугольник с такими сторонами.");
        }
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public Rectangle(double[] sides, Color backgroundColor, Color borderColor){
        this(sides[0], sides[1], backgroundColor, borderColor);
        if (sides.length != COUNT_SIDES) {
            throw new IllegalArgumentException("Укажите для прямоугольника высоту и ширину.");
        }
    }

    private boolean isValidRectangle(double a, double b) {
        return a > 0 && b > 0;
    }

    @Override
    public double[] getSizes() {
        return new double[]{width, height, width, height};
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
