package org.example.Figures;

public interface Shape {
    double getArea();
    double[] getSizes();

    default double getPerimeter() {
        double[] sizes = getSizes();
        double perimeter = 0.0;
        if (sizes.length == 1) {
            return 2 * Math.PI * sizes[0];
        }
        for (double size:sizes) {
            perimeter += size;
        }
        return perimeter;
    }
}
