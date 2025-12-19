package org.example.Figures;

import java.awt.*;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius, Color backgroundColor, Color borderColor) {
        if (!isValidCircle(radius)) {
            throw new IllegalArgumentException("Невозможно построить круг с таким радиусом");
        }
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    private boolean isValidCircle(double r) {
        return r > 0;
    }

    @Override
    public double[] getSizes() {
        return new double[]{this.radius};
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}
